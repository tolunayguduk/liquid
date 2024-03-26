import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Catalog = () => {


    const [queryParameters] = useState(new URLSearchParams(window.location.search));
    const [catalogData, setCatalogData] = useState([]);


    useEffect(() => {
        getCatalog(queryParameters.get("key"));
    }, [queryParameters]);

    const getCatalog = (key) => {
        axios.get('/product/catalog/' + key).then((res) => {
            setCatalogData(res.data);
        }).catch(() => {

        });
    }

    return (
        <div>
            {catalogData}
        </div>
    );
}

export default Catalog;