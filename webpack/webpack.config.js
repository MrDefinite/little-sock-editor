var path = require("path");
var webpack = require('webpack');
var $base = '..';
var buildConfig = require($base + '/buildConfig')($base);

var commonLoaders = [
    {
        test: /\.jsx?$/,
        loader: "babel-loader",
        include: path.join(__dirname, buildConfig.clientSrc),
        query: {
            presets:['react', 'es2015']
        }
    },
    {
        test: /\.json$/,
        loader: 'json-loader'
    },
    {
        test: /\.png$/,
        loader: 'url-loader'
    },
    {
        test: /\.jpg$/,
        loader: 'file-loader'
    },
    {
        test: /\.ftl$/,
        loader: 'html-loader'
    },
    {
        test: /\.html$/,
        loader: 'html-loader'
    },
    {
        test: /\.less$/,
        loader: 'less-loader'
    }
];


module.exports = {
    context: path.join(__dirname, buildConfig.clientSrc),
    entry: {
        app: './app'
    },
    output: {
        path: path.join(__dirname, buildConfig.clientPublic),
        filename: 'bundle.js',
        publicPath: '/'
    },
    resolve: {
        modulesDirectories: [
            'client',
            'node_modules'
        ],
        extensions: ['', '.js', '.jsx', '.less', '.json']
    },
    module: {
        loaders: commonLoaders
    }
};
