import React, { useState, useEffect } from 'react';
import { Descriptions, Card, Col, Row, Modal } from 'antd';
import CategoryModal from '../components/CategoryModal';
import ProductsModal from '../components/ProductsModal';
import axios from 'axios';

const DashboardHeader = (props) => {

    const [isModalOpen, setIsModalOpen] = useState(false);
    const [modalType, setModalType] = useState("");

    const [productData, setProductData] = useState([]);
    const [categoryData, setCategoryData] = useState([]);


    useEffect(() => {
        getCategories();
        getProducts();
    }, []);

    const showModal = (type) => {
        setIsModalOpen(true);
        setModalType(type)
    };

    const handleOk = () => {
        setIsModalOpen(false);
    };

    const handleCancel = () => {
        setIsModalOpen(false);
    };

    const getCategories = () => {
        axios.get('/product/category/retrieve').then((res) => {
            setCategoryData(res.data);
        }).catch(() => {

        });
    }

    const getProducts = () => {
        axios.get('/product/product/retrieve').then((res) => {
            setProductData(res.data);
        }).catch(() => {

        });
    }

    const items = [
        {
            key: '1',
            label: 'Address',
            children: 'No. 18, Wantang Road, Xihu District, Hangzhou, Zhejiang, China',
        },
    ];

    return (
        <div className='container-xxl p-2'>
            <div className='row'>
                <div className='col-12'>
                    <Row gutter={16}>
                        <Col span={8}>
                            <Card title="Categories" bordered={false} onClick={() => showModal("Categories")}>
                                <h4>{categoryData.length}</h4>Click to Manage Categories
                            </Card>
                        </Col>
                        <Col span={8}>
                            <Card title="Products" bordered={false} onClick={() => showModal("Products")}>
                                <h4>{productData.length}</h4>Click to Manage Products
                            </Card>
                        </Col>
                        <Col span={8}>
                            <Card title="Visits" bordered={false}>
                                <h4>1,125,759</h4> visit per day
                            </Card>
                        </Col>
                    </Row>
                </div>
            </div>
            <div className='row'>
                <div className='col-12 p-4'>
                    <Descriptions items={items} />
                </div>
            </div>
            <Modal title={"Manage " + modalType}
                open={isModalOpen}
                onOk={handleOk}
                onCancel={handleCancel}
                width={"80%"}>
                {modalType === "Categories" &&
                    <CategoryModal categoryData={categoryData} refreshCategories={() => getCategories()} />
                }
                {modalType === "Products" &&
                    <ProductsModal productData={productData} refreshProducts={() => getProducts()} />
                }
            </Modal>
        </div>
    );
}

export default DashboardHeader;