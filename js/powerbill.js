function calc(){
    var tier1 = 0;
    var tier2 = 0;
    var tier3 = 0;
    var base = 0;
    var baseR = 0;
    var FCR = 0;
    var DSMRR = 0;
    var NCCRR = 0;
    var ECCRR = 0;
    var totalR = 0;
    var FF = 0;
    var total = 0;
    var totalT = 0;
    const month = document.getElementById("summer");
    const cityC = document.getElementById("city");
    const daynum = parseFloat(document.getElementById('days').value) || 0;
    const tax = (parseFloat(document.getElementById('tax').value) || 0)/100;
    const use = parseFloat(document.getElementById('usage').value) || 0;

    base = 0.4603 * daynum;
    if(month.checked){
        FCR = use * 0.045876;
        if(use <= 650){
            tier1 = use * 0.066678;
        }else if(use <= 1000){
            tier1 = 650 * 0.066678;
            tier2 = (use-650) * 0.110748;
        }else if(use > 1000){
            tier1 = 650 * 0.066678;
            tier2 = 350 * 0.110748;
            tier3 = (use-1000) * 0.114625;
        }
    }else{
        FCR = use * 0.042859;
        if(use <= 650){
            tier1 = use * 0.062404;
        }else if(use <= 1000){
            tier1 = 650 * 0.062404;
            tier2 = (use-650) * 0.062404;
        }else if(use > 1000){
            tier1 = 650 * 0.062404;
            tier2 = 350 * 0.062404;
            tier3 = (use-1000) * 0.062404;
        }
    }

    baseR = base + tier1 + tier2 + tier3;
    DSMRR = baseR * 0.015989;
    NCCRR = baseR * 0.041562;
    ECCRR = baseR * 0.162813;
    totalR = baseR + FCR + DSMRR + NCCRR + ECCRR;

    if(cityC.checked){
        FF = totalR * 0.030674;
    }else{
        FF = totalR * 0.011839;
    }

    total = totalR + FF;
    totalT = total * (1+tax);

    document.getElementById("BC").textContent = ("$" + base.toFixed(2));
    document.getElementById("T1C").textContent = ("$" + tier1.toFixed(2));
    document.getElementById("T2C").textContent = ("$" + tier2.toFixed(2));
    document.getElementById("T3C").textContent = ("$" + tier3.toFixed(2));
    document.getElementById("BR").textContent = ("$" + baseR.toFixed(2));
    document.getElementById("FCR").textContent = ("$" + FCR.toFixed(2));
    document.getElementById("DSMRR").textContent = ("$" + DSMRR.toFixed(2));
    document.getElementById("NCCRR").textContent = ("$" + NCCRR.toFixed(2));
    document.getElementById("ECCRR").textContent = ("$" + ECCRR.toFixed(2));
    document.getElementById("TR").textContent = ("$" + totalR.toFixed(2));
    document.getElementById("FF").textContent = ("$" + FF.toFixed(2));
    document.getElementById("totalet").textContent = ("$" + total.toFixed(2));
    document.getElementById("totalwt").textContent = ("$" + totalT.toFixed(2));

    if(total > 500){
        window.open("https://www.georgiapower.com/residential/save-money-and-energy.html", "_blank");
    }
}
const form = document.querySelector('form[name="bill"]');
form.addEventListener("submit", function(e) {
    e.preventDefault();
    calc();
});