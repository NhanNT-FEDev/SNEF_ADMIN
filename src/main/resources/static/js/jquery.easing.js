/*
 * jQuery Easing v1.4.1 - http://gsgd.co.uk/sandbox/jquery/easing/
 * Open source under the BSD License.
 * Copyright © 2008 George McGinley Smith
 * All rights reserved.
 * https://raw.github.com/gdsmith/jquery-easing/master/LICENSE
*/

(function (factory) {
    if (typeof define === "function" && define.amd) {
        define(['jquery'], function ($) {
            return factory($);
        });
    } else if (typeof module === "object" && typeof module.exports === "object") {
        exports = factory(require('jquery'));
    } else {
        factory();
    }
})(function ($) {

// Preserve the original jQuery "swing" easing as "jswing"
//$.easing.jswing = $.easing.swing;

    var pow = Math.pow,
        sqrt = Math.sqrt,
        sin = Math.sin,
        cos = Math.cos,
        PI = Math.PI,
        c1 = 1.70158,
        c2 = c1 * 1.525,
        c3 = c1 + 1,
        c4 = (2 * PI) / 3,
        c5 = (2 * PI) / 4.5;

// x is the fraction of animation progress, in the range 0..1
    function bounceOut(x) {
        var n1 = 7.5625,
            d1 = 2.75;
        if (x < 1 / d1) {
            return n1 * x * x;
        } else if (x < 2 / d1) {
            return n1 * (x -= (1.5 / d1)) * x + 0.75;
        } else if (x < 2.5 / d1) {
            return n1 * (x -= (2.25 / d1)) * x + 0.9375;
        } else {
            return n1 * (x -= (2.625 / d1)) * x + 0.984375;
        }
    }
});
