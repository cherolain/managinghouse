

$(document).ready(function() {
    $('.member').click(function(event) {
        if (confirm('Vuoi confermare?')) {
            var url = $(this).attr('href');
            $('#content').load(url);
        }else {
            event.preventDefault();
        }
    });

    let tableElements= document.getElementsByClassName("modifica");


    for(let i=0;i<tableElements.length;i++){
        tableElements[i].addEventListener("click",(event)=>{
            var element = event.target.parentNode.parentNode;
            console.log(element);
            var nome = element.querySelectorAll('td')[1].textContent;
            var punti =element.querySelectorAll('td')[2].textContent;
            var id=element.querySelectorAll('input')[0].value;
            document.getElementById("nome").value = nome;
            document.getElementById("punti").value = punti;
            document.getElementById("id").value = id;
            document.getElementById("aggiungifa").textContent="Modifica faccenda";
        });
    }
});



  /*  ciao.addEventListener("click",function (){
            var count = element.querySelectorAll('td')[0].textContent;
            var nome = element.querySelectorAll('td')[1].textContent;
            var punti = element.querySelectorAll('td')[2].value();
            console.log(nome,punti);
        document.getElementById("nome").value = nome;
        document.getElementById("punti").value = punti;*/
/*
    }
    )*/




function show(nr) {
    var t;
    if(nr==1){
        t=2;
    }else t=1;

    if(document.getElementById("table"+nr).style.display=="block"){
        document.getElementById("table"+nr).style.display="none";
        document.getElementById("table"+t).style.display="none";
    }else
        document.getElementById("table"+nr).style.display="block";
        document.getElementById("table"+t).style.display="none";
}