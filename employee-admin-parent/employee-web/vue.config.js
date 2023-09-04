module.exports = {
	devServer: {
      proxy: {
      '/api': {// 匹配所有以 '/api1'开头的请求路径
        target: 'http://localhost:9000',// 代理目标的基础路径
        changeOrigin: true,
        pathRewrite: {'^/api': ''} // 代理到服务器的时候，去除api路径
      },
    }
  }
}
/*
   changeOrigin设置为true时，服务器收到的请求头中的host为：localhost:5000
   changeOrigin设置为false时，服务器收到的请求头中的host为：localhost:8080
   changeOrigin默认值为true
*/
