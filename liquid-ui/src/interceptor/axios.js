import axios from "axios";

axios.defaults.baseURL = 'http://localhost:8000';
axios.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
axios.defaults.headers.common['Access-Control-Allow-Methods'] = 'DELETE, POST, GET, OPTIONS';
axios.defaults.headers.common['Access-Control-Allow-Headers'] = 'Content-Type, Authorization, X-Requested-With';
axios.defaults.headers.common['Content-Type'] = "application/json"

axios.interceptors.request.use(function (config) {
  if(localStorage.getItem('token')){
    const access_token = JSON.parse(localStorage.getItem('token')).access_token;
    config.headers.Authorization =  access_token ? `Bearer ${access_token}` : '';
  }
  // Do something before request is sent
  return config;
}, function (error) {
  debugger
  // Do something with request error
  return Promise.reject(error);
});


axios.interceptors.response.use(function (response) {
  // Do something with response data
  return response;
}, function (error) {
  // Do something with response error
  return Promise.reject(error);
});


