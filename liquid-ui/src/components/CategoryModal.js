import React, { useState } from 'react';
import { categoryTableColumns } from '../constant/TableColumns';
import { Table, Modal, Form, Input, Switch, Button } from 'antd';
import axios from 'axios';


const CategoryModal = (props) => {


    const [formVisible, setFormVisible] = useState(false);
    const [form] = Form.useForm();

    const editCategory = (value, record) => {
        setFormVisible(true);
        form.setFieldsValue(record);
    }



    const handleOk = (values) => {
        if (values.operation === "delete") {
            axios.delete('/product/category/delete/' + values.id).then((res) => {
                setFormVisible(false);
                props.refreshCategories();
            }).catch(() => {

            });
        } else if (values.operation === "edit") {
            axios.put('/product/category/update/' + values.id, values).then((res) => {
                setFormVisible(false);
                props.refreshCategories();
            }).catch(() => {

            });
        } else if (values.operation === "add") {
            axios.post('/product/category/create', values).then((res) => {
                setFormVisible(false);
                props.refreshCategories();
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
            <Button onClick={(value, record) => editCategory(value, { ...record, ...{ operation: "add", status: false } })} type="primary">
                Add new Category
            </Button>
            <Table
                columns={
                    categoryTableColumns(
                        (value, record) => editCategory(value, { ...record, ...{ operation: "edit" } }),
                        (value, record) => editCategory(value, { ...record, ...{ operation: "delete" } })
                    )}
                dataSource={props.categoryData} />
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

export default CategoryModal;