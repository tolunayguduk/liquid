import React, { useEffect, useState } from 'react';
import { Table, Tabs } from 'antd';
import axios from 'axios';
import { categoryTableColumns, productTableColumns } from '../constant/TableColumns';

const DashboardBody = (props) => {

    const [tabs, setTabs] = useState([])
    const [columns, setColums] = useState([]);
    const [categoryData, setCategoryData] = useState([]);
    const [productData, setProductData] = useState([]);


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


    useEffect(() => {
        setTabs(["Categories", "Products"]);
        setColums([categoryTableColumns(), productTableColumns()]);
        getCategories();
        getProducts();
    }, []);

    return (
        <div className='row mt-3'>
            <div className='col-12'>
                <Tabs
                    defaultActiveKey="1"
                    items={new Array(2).fill(null).map((_, i) => {

                        return {
                            label: tabs[i],
                            key: i,
                            children: <Table
                                columns={columns[i]}
                                dataSource={[categoryData,productData][i]} />,
                        };
                    })}
                />
            </div>
        </div>
    );
}

export default DashboardBody;