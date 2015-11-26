var path = require("path");
var webpack = require('webpack');
var $base = '..';
var $build = $base + '/build';
var $clientTarget = $build + '/client_target';
var $clientSrc = $base + '/client';
var $nodeModules = $base + '/node_modules'
var $public = 'socky-editor/';

var commonLoaders = [
    {
        test: /\.jsx?$/,
        loader: "babel-loader",
        include: path.join(__dirname, $clientSrc),
        query: {
            presets:['react', 'es2015']
        }
    },
    {
        test: /\.json$/,
        loader: "json-loader"
    },
    {
        test: /\.png$/,
        loader: "url-loader"
    },
    {
        test: /\.jpg$/,
        loader: "file-loader"
    },
    {
        test: /\.html$/,
        loader: "html-loader"
    },
    {
        test: /\.less$/,
        loader: "less-loader"
    }
];


module.exports = {
    context: path.join(__dirname, $clientSrc),
    entry: {
        app: './app'
    },
    output: {
        path: path.join(__dirname, $clientTarget),
        filename: 'bundle.js',
        publicPath: '/'
    },
    resolve: {
        extensions: ['', '.js', '.jsx', '.less']
    },
    module: {
        loaders: commonLoaders
    }
};
