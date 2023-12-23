import React, { useEffect } from 'react';

const Home = (props) => {

    useEffect(() => {
        if (!localStorage.getItem('user')) {
            window.location.href = "/login";
        }
    }, []);

    return (
        <div className='container-xxl p-3'>
            <h3>Hi {localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).name : ''}, Welcome to Liquid UI!</h3>
        </div>
    );
}

export default Home;