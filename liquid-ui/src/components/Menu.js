import React, { useState } from 'react';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Offcanvas from 'react-bootstrap/Offcanvas';

const Menu = (props) => {

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const onLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("user");
        window.location.href = "/";
    }

    return (
        <div>
            <Navbar className="bg-body-tertiary justify-content-between">
                <Container>
                    <Navbar.Brand onClick={handleShow}>
                        <i className="bi bi-bullseye"></i> Liquid
                    </Navbar.Brand>
                    <Navbar.Toggle />
                    <Navbar.Collapse className="justify-content-end">
                        <Navbar.Text>
                            <a href='/profile'>{localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).username : ''}</a>
                        </Navbar.Text>
                        <Navbar.Text>
                            {(localStorage.getItem('token') ? JSON.parse(localStorage.getItem('token')).access_token : false) ?
                                (
                                    <button type="button" className="btn btn-default btn-sm" onClick={() => { onLogout() }}>
                                        <span className="glyphicon glyphicon-log-out"></span> Log out
                                    </button>
                                ) :
                                (
                                    <div></div>
                                )
                            }
                        </Navbar.Text>
                    </Navbar.Collapse>
                </Container>
            </Navbar>
            {(localStorage.getItem('token') ? JSON.parse(localStorage.getItem('token')).access_token : false) ?
                (
                    <Offcanvas show={show} onHide={handleClose} >
                        <Offcanvas.Header closeButton>
                            <Offcanvas.Title><i className="bi bi-bullseye"></i> {localStorage.getItem('user') ? JSON.parse(localStorage.getItem('user')).username : ''}</Offcanvas.Title>
                        </Offcanvas.Header>
                        <Offcanvas.Body>
                            Welcome to Liquid UI
                        </Offcanvas.Body>
                    </Offcanvas>
                ) :
                (
                    <div></div>
                )
            }
        </div>
    );
}

export default Menu;