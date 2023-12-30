import { Tag } from 'antd';
import { EditTwoTone } from '@ant-design/icons';

export function categoryTableColumns() {
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
        width: '30%',
    },
    {
        key: 2,
        title: 'Status',
        dataIndex: 'status',
        render: (item) => {
            if (item === true) {
                return <Tag color="success">{String(item ? "Active" : "Passive")}</Tag>
            } else {
                return <Tag color="error">{String(item)}</Tag>
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
        filterMode: 'tree',
        filterSearch: true,
        onFilter: (value, record) => record.name.includes(value),
        width: '10%',
    }];
}

export function productTableColumns() {
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
        width: '45%',
    },
    {
        key: 5,
        title: 'Status',
        dataIndex: 'status',
        render: (item) => {
            if (item === true) {
                return <Tag color="success">{String(item ? "Active" : "Passive")}</Tag>
            } else {
                return <Tag color="error">{String(item)}</Tag>
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
        filterMode: 'tree',
        filterSearch: true,
        onFilter: (value, record) => record.name.includes(value),
        width: '10%',
    },
    {
        title: '',
        dataIndex: '',
        width: '5%',
        render: (record) => {
            return (<div>
                <EditTwoTone />
            </div>);
        },
    }];
}