import React, { useEffect, useState } from 'react';
import Post from '../components/Post';

const Profile = (props) => {

    const [user, setUser] = useState({});



    useEffect(() => {
        if (!localStorage.getItem('user')) {
            window.location.href = "/login";
        } else {
            setUser(JSON.parse(localStorage.getItem('user')));
        }
    }, []);


    return (
        <div className='container-xxl p-2'>
            <div className="main-body">
                <div className="row gutters-sm">
                    <div className="col-md-4 mb-3">
                        <div className="card">
                            <div className="card-body">
                                <div className="d-flex flex-column align-items-center text-center">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" className="rounded-circle" width="150" />
                                    <div className="mt-3">
                                        <h4>{user.name}</h4>
                                        <p className="text-secondary mb-1">{user.username}</p>
                                        <p className="text-muted font-size-sm">Computer Science- Software Developer</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div className="col-md-8">
                        <Post user={user} />
                        <Post user={user} />
                        <Post user={user} />
                        <Post user={user} />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Profile;