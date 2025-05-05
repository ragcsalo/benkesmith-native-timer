var exec = require('cordova/exec');
var nextId = 1;
var callbacks = {};

var NativeTimer = {
  setTimeout: function (callback, ms) {
    const id = nextId++;
    callbacks[id] = callback;
    exec(
      () => {
        if (callbacks[id]) {
          callbacks[id]();
          delete callbacks[id];
        }
      },
      null,
      'NativeTimer',
      'setTimeout',
      [id, ms]
    );
    return id;
  },

  clearTimeout: function (id) {
    delete callbacks[id];
    exec(null, null, 'NativeTimer', 'clearTimeout', [id]);
  }
};

module.exports = NativeTimer;

