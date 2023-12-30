const {createProxyMiddleware} = require('http-proxy-middleware');
    module.exports = function (app) {
      app.use(createProxyMiddleware('/auth/**', {target: 'http://localhost:8000/auth'}));
      app.use(createProxyMiddleware('/product/**', {target: 'http://localhost:8000/product'}));
}