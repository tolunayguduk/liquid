import React from 'react';
import Menu from './components/Menu';
import Login from './pages/Login';
import Home from './pages/Home';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Profile from './pages/Profile';
import Catalog from './pages/Catalog';

const App = () => {

  return (
    <BrowserRouter>
      <div className="App">
        <Menu />
        <div className='auth-wrapper'>
          <div className='auth-inner'>
            <Routes>
              <Route path='/' element={<Home />} />
              <Route path='/login' element={<Login />} />
              <Route path='/profile' element={<Profile />} />
              <Route path='/catalog' element={<Catalog />} />
            </Routes>
          </div>
        </div>
      </div>
    </BrowserRouter>

  );
}

export default App;
