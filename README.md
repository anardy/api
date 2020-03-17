# api

const argv = require('minimist')(process.argv.slice(2));
const alert = require('alert-node');

let hourEntrada = argv.e || 0;
let hourHang = argv.a || 0;
let hourHangBack = argv.v || 0;

let hourGoOut = 0;

let WORK_HOURS = 8;

if (hourEntrada !== 0) {
    let split = hourEntrada.split(':');
    let today = new Date();
    hourEntrada = new Date(today.getFullYear(), today.getMonth(), today.getDate(), split[0], split[1], null, null);
    add(hourEntrada);
}

// calcula almoco
if ((hourHang !== 0) && (hourHangBack !== 0)) {
    let split = hourHang.split(':');
    let split2 = hourHangBack.split(':');
    let today = new Date();
    hourHang = new Date(today.getFullYear(), today.getMonth(), today.getDate(), split[0], split[1], null, null);
    hourHangBack = new Date(today.getFullYear(), today.getMonth(), today.getDate(), split2[0], split2[1], null, null);
    show(sub(hourHang, hourHangBack));
}


function add(hourEntrada) {
    return hourEntrada.setTime(hourEntrada.getTime() + (WORK_HOURS*60*60*1000));
}

function sub(hourHang, hourHangBack) {
    let hour = Math.abs(hourHang - hourHangBack) / 36e5;
    return hourEntrada.setTime(hourEntrada.getTime() + (hour*60*60*1000));
}

function show(hourSaida) {
let t = new Date(hourSaida)
var year = t.getFullYear();
var month = ("0" + (t.getMonth() + 1)).slice(-2);
var day = ("0" + t.getDate()).slice(-2);

var hour = ("0"+ t.getHours()).slice(-2);
var minutes = t.getMinutes();

console.log(`${day}/${month}/${year} ${hour}:${minutes}`)
hourGoOut = new Date(year, t.getMonth(), t.getDate(), hour, minutes);
}

let refreshIntervalId = setInterval(function () {
    if (hourGoOut === new Date()) {
        alert('Hora de ir embora')
        stop();
    }
}, 2000);

function stop() {
    clearInterval(refreshIntervalId);
}
