import React from 'react';
import { Descriptions, Card, Col, Row } from 'antd';

const DashboardHeader = (props) => {

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
                            <Card title="Categories" bordered={false}>
                                <h4>23</h4>category
                            </Card>
                        </Col>
                        <Col span={8}>
                            <Card title="Products" bordered={false}>
                                <h4>412</h4>product
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
                    <Descriptions title="" items={items} />
                </div>
            </div>
        </div>
    );
}

export default DashboardHeader;