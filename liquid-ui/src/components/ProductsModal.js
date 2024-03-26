import React, { useState } from 'react';
import { productTableColumns } from '../constant/TableColumns';
import { Table, Modal, Form, Input, Switch, Button, Select } from 'antd';
import axios from 'axios';

const ProductsModal = (props) => {
    const [formVisible, setFormVisible] = useState(false);
    const [form] = Form.useForm();

    const editProduct = (value, record) => {
        setFormVisible(true);
        form.setFieldsValue(record);
    }

    const handleOk = (values) => {
        if (values.operation === "delete") {
            axios.delete('/product/product/delete/' + values.id).then((res) => {
                setFormVisible(false);
                props.refreshProducts();
            }).catch(() => {

            });
        } else if (values.operation === "edit") {
            axios.put('/product/product/update/' + values.id, values).then((res) => {
                setFormVisible(false);
                props.refreshProducts();
            }).catch(() => {

            });
        } else if (values.operation === "add") {
            axios.post('/product/product/create', values).then((res) => {
                setFormVisible(false);
                props.refreshProducts();
            }).catch(() => {

            });
        }
        form.resetFields();
    };

    const handleCancel = (event) => {
        setFormVisible(false);
        form.resetFields();
    };

    return (
        <div>
            <Button onClick={(value, record) => editProduct(value, { ...record, ...{ operation: "add", status: false } })} type="primary">
                Add new Product
            </Button>
            <Table
                columns={
                    productTableColumns(
                        (value, record) => editProduct(value, { ...record, ...{ operation: "edit" } }),
                        (value, record) => editProduct(value, { ...record, ...{ operation: "delete" } }),
                        props.categoryData
                    )}
                dataSource={props.productData} />
            <Modal title={"Edit"}
                open={formVisible}
                onOk={form.submit}
                onCancel={handleCancel}
                width={"60%"}>
                <Form form={form} onFinish={handleOk}>
                    <Form.Item
                        label="Id"
                        name="id" hidden>
                        <Input />
                    </Form.Item>
                    <Form.Item
                        label="Operation"
                        name="operation" hidden>
                        <Input />
                    </Form.Item>
                    {form.getFieldValue("operation") === "delete" ?
                        (
                            <p>Bu kategoriyi silmek istediğinize emin misiniz?</p>
                        ) :
                        (
                            <div>
                                <Form.Item
                                    label="Name"
                                    name="name"
                                    rules={[{ required: true }]}>
                                    <Input />
                                </Form.Item>
                                <Form.Item
                                    label="Category"
                                    name="categoryId"
                                    rules={[{ required: true }]}>
                                    <Select
                                        defaultValue={form.getFieldValue("categoryId")}
                                        allowClear
                                        options={props.categoryData.map((category) => {return {value: category.id, label:category.name}})}
                                    />
                                </Form.Item>
                                <Form.Item
                                    label="Price"
                                    name="price"
                                    rules={[{ required: true }]}>
                                    <Input />
                                </Form.Item>
                                <Form.Item
                                    label="İmage Link"
                                    name="imageLink"
                                    rules={[{ required: false }]}>
                                    <Input />
                                </Form.Item>
                                <Form.Item
                                    name="status"
                                    label="Status"
                                    value={true}
                                    valuePropName="checked">
                                    <Switch
                                        value={true} />
                                </Form.Item>
                            </div>
                        )
                    }
                </Form>
            </Modal>
        </div>
    );
}

export default ProductsModal;