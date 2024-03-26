import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Catalog = () => {


    const [queryParameters] = useState(new URLSearchParams(window.location.search));
    const [categoryData, setCategoryData] = useState([]);
    const [productData, setProductData] = useState([]);



    useEffect(() => {
        getCatalogCategories(queryParameters.get("key"));
        getCatalogProducts(queryParameters.get("key"));
    }, [queryParameters]);

    const getCatalogCategories = (key) => {
        axios.get('/product/catalog/' + key + "/categories").then((res) => {
            setCategoryData(res.data);
        }).catch(() => {

        });
    }

    const getCatalogProducts = (key) => {
        axios.get('/product/catalog/' + key + "/products").then((res) => {
            setProductData(res.data);
        }).catch(() => {

        });
    }

    return (
        <div className='container-xxl p-2'>
            <div className="main-body">
                <div className="row gutters-sm">
                    <div className="accordion m-3" id="accordionExample">
                        {categoryData.map((category, i) => {
                            return (
                                <div className="accordion-item">
                                    <h2 className="accordion-header" id={'heading' + i}>
                                        <button className="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target={'#' + 'CAT' + category.id} aria-expanded="true" aria-controls={'CAT' + category.id}>
                                            {category.name}
                                        </button>
                                    </h2>
                                    <div id={'CAT' + category.id} className="accordion-collapse collapse show" aria-labelledby={'heading' + i} data-bs-parent={'#' + 'CAT' + category.id + '_' + i}>
                                        <div className="accordion-body">
                                            <div class="card-group">
                                                {productData.filter((pr) => { return pr.categoryId === category.id }).map((product, p) => {
                                                    return (

                                                        <div className="card m-2" style={{ width: "18rem" }}>
                                                            <img src="https://images.pexels.com/photos/376464/pexels-photo-376464.jpeg" class="card-img-top" alt={product.name} />
                                                            <div className="card-body">
                                                                <h5 className="card-title"><strong>{product.name}</strong></h5>
                                                                <p className="card-text"><strong>{product.price + ' ₺'}</strong></p>
                                                                <p className="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                                                            </div>
                                                        </div>
                                                    )
                                                })}
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            )
                        })}
                    </div>
                </div>
            </div>
        </div>

    );
}

export default Catalog;