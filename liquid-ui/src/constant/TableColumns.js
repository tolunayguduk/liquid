import { Tag, Button, Divider, Flex } from 'antd';
import { DeleteOutlined, EditOutlined } from '@ant-design/icons';

export function categoryTableColumns(onEdit, onDelete) {
    return [{
        key: 0,
        title: 'Id',
        dataIndex: 'id',
        width: '10%'
    },
    {
        key: 1,
        title: 'Name',
        dataIndex: 'name',
        width: '70%'
    },
    {
        key: 2,
        title: 'Status',
        dataIndex: 'status',
        render: (item) => {
            if (item === true) {
                return <Tag color="success">{String(item ? "Active" : "Passive")}</Tag>
            } else {
                return <Tag color="error">{String(item ? "Active" : "Passive")}</Tag>
            }
        },
        filters: [
            {
                text: 'Active',
                value: true,
            },
            {
                text: 'Passive',
                value: false,
            }
        ],
        filterSearch: true,
        onFilter: (value, record) => { return record.status === value },
        width: '10%',
    },
    {
        key: 1,
        title: 'Actions',
        width: '10%',
        render: (value, record) => {
            return (
                <Flex >
                    <Button onClick={() => onEdit(value, record)} type="primary" icon={<EditOutlined />} />
                    <Divider type="vertical" />
                    <Button onClick={() => onDelete(value, record)} type="primary" icon={<DeleteOutlined />} danger />
                </Flex>
            );
        }
    }];
}

export function productTableColumns(onEdit, onDelete) {
    return [{
        key: 0,
        title: 'Id',
        dataIndex: 'id',
        width: '10%',
    },
    {
        key: 1,
        title: 'Name',
        dataIndex: 'name',
        width: '10%',
    },
    {
        key: 2,
        title: 'Category',
        dataIndex: 'category',
        width: '10%',
        render: (item) => item.name
    },
    {
        key: 3,
        title: 'Price',
        dataIndex: 'price',
        width: '10%',
    },
    {
        key: 4,
        title: 'Image Link',
        dataIndex: 'imageLink',
        width: '40%',
    },
    {
        key: 5,
        title: 'Status',
        dataIndex: 'status',
        render: (item) => {
            if (item === true) {
                return <Tag color="success">{String(item ? "Active" : "Passive")}</Tag>
            } else {
                return <Tag color="error">{String(item ? "Active" : "Passive")}</Tag>
            }
        },
        filters: [
            {
                text: 'Active',
                value: true,
            },
            {
                text: 'Passive',
                value: false,
            }
        ],
        filterSearch: true,
        onFilter: (value, record) => { return record.status === value },
        width: '10%',
    },
    {
        key: 1,
        title: 'Actions',
        width: '10%',
        render: (value, record) => {
            return (
                <Flex >
                    <Button onClick={() => onEdit(value, record)} type="primary" icon={<EditOutlined />} />
                    <Divider type="vertical" />
                    <Button onClick={() => onDelete(value, record)} type="primary" icon={<DeleteOutlined />} danger />
                </Flex>
            );
        }
    }];
}