var $build = '/build',
    $clientTarget = $build + '/client_target',
    $clientPublic = $clientTarget + '/public',
    $clientSrc = '/client',
    $clientEntry = $clientSrc + '/index.ftl',
    $nodeModules = '/node_modules';

module.exports = function(base) {
    return {
        build: base + $build,
        clientTarget: base + $clientTarget,
        clientPublic: base + $clientPublic,
        clientSrc: base + $clientSrc,
        clientEntry: base + $clientEntry,
        nodeModules: base + $nodeModules
    };
};