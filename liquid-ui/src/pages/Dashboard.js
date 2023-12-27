import React from 'react';

const Dashboard = (props) => {

    return (
        <div className='container-xxl p-2'>
            <div className='row'>

                <div className='col-3'>
                    <div class="card text-bg-secondary p-3">

                        <h5 class="card-title"> <i className="bi bi-bullseye"></i> Category</h5>
                        <p class="card-text">36</p>
                        <p class="card-text"><small>Last updated 3 mins ago</small></p>
                    </div>
                </div>

                <div className='col-3'>
                    <div class="card text-bg-success p-3">

                        <h5 class="card-title"> <i className="bi bi-bullseye"></i> Product</h5>
                        <p class="card-text">1,635</p>
                        <p class="card-text"><small>Last updated 3 mins ago</small></p>
                    </div>
                </div>

                <div className='col-3'>
                    <div class="card text-bg-info p-3">

                        <h5 class="card-title"> <i className="bi bi-bullseye"></i> Visit</h5>
                        <p class="card-text">1,125,956</p>
                        <p class="card-text"><small>In last 1 month</small></p>
                    </div>
                </div>

                <div className='col-3'>
                    <div class="card text-bg-danger p-3">

                        <h5 class="card-title"> <i className="bi bi-bullseye"></i> Category</h5>
                        <p class="card-text">36</p>
                        <p class="card-text"><small>Last updated 3 mins ago</small></p>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default Dashboard;