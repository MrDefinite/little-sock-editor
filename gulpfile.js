// Tools
var gulp = require('gulp');
var gutil = require("gulp-util");
var uglify = require('gulp-uglify');
var gzip = require('gulp-gzip');
var minifyCss = require('gulp-minify-css');
var webpack = require('webpack');
var WebpackDevServer = require('webpack-dev-server');

// Webpack config file
var webpackConfig = require('./webpack/webpack.config.js');
var webpackDevServerConfig = require('./webpack/webpack-dev-server.js');

// Path
var $build = './build';
var $clientTarget = $build + '/client_target';
var $clientSrc = './client';
var $clientEntry = $clientSrc + '/index.html';
var $nodeModules = './node_modules';

gulp.task('entry', function() {
    return gulp.src($clientEntry).pipe(gulp.dest($clientTarget));
});

gulp.task('webpack', function(callback) {
    // run webpack
    webpack(webpackConfig, function(err, stats) {
        if(err) throw new gutil.PluginError("webpack", err);
        gutil.log("[webpack]", stats.toString({
            // output options
            colors: true
        }));
        callback();
    });
});

gulp.task('webpackDevServer', function() {
    // Start a webpack-dev-server
    var compiler = webpack(webpackDevServerConfig);

    new WebpackDevServer(compiler, {
        // server and middleware options
    }).listen(8080, "localhost", function(err) {
        if(err) throw new gutil.PluginError("webpack-dev-server", err);
        // Server listening
        gutil.log("[webpack-dev-server]", "http://localhost:8080/webpack-dev-server/index.html");

        // keep the server alive or continue?
        // callback();
    });
});

gulp.task('production', ['webpack', 'entry']);

gulp.task('dev', function() {

});

gulp.task('default', ['webpackDevServer']);


