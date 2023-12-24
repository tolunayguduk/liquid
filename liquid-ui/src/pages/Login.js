import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Login = (props) => {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState(false);

    useEffect(() => {
        if (localStorage.getItem('user')) {
            window.location.href = "/";
        }
    }, []);

    const onSubmit = (e) => {
        e.preventDefault();

        var loginRequest = {
            username: username,
            password: password
        }
        axios.post('/auth/login', loginRequest).then((res) => {
            localStorage.setItem('token', JSON.stringify(res.data));
            axios.get('/auth/introspect').then((res) => {
                localStorage.setItem('user', JSON.stringify(res.data));
                window.location.href = "/";
            }).catch(() => {
                window.location.href = "/login";
            });
        }).catch((err) => {
            console.log(err);
            setError(true);
        });
    }

    return (
        <div className='container-xxl p-3'>
            <form className="needs-validation" onSubmit={onSubmit}>
                {error ?
                    (
                        <div className="form-row">
                            <div className="col-md-4 mb-3">
                                <div class="alert alert-danger p-1 m-0" role="alert">
                                    <p>Kullanıcı adı ya da parola hatalı</p>
                                </div>
                            </div>
                        </div>
                    ) : (
                        <div></div>
                    )
                }
                <div className="form-row">
                    <div className="col-md-4 mb-3">
                        <label>Username</label>
                        <div className="input-group">
                            <input
                                id="username"
                                type="text"
                                className="form-control"
                                placeholder="Enter username"
                                required={true}
                                onChange={(e) => { setUsername(e.target.value) }} />
                        </div>
                    </div>
                </div>
                <div className="form-row">
                    <div className="col-md-4 mb-3">
                        <label>Password</label>
                        <input
                            id="password"
                            type="password"
                            className="form-control"
                            placeholder="Password"
                            required={true}
                            onChange={(e) => { setPassword(e.target.value) }} />
                    </div>
                </div>
                <button className="btn btn-primary" type="submit">Login</button>
            </form>
        </div>
    );
}

export default Login;