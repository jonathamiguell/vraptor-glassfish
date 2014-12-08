///* 
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//jQuery(document).ready(function(){
//$('#login').submit(function(){ //Primeiro temos que interceptar o evento submit do form
//$('#loader').show(); //Aqui para uma simples "perfumaria" exibimos um gif para dizer que está "carregando.."
//$(this).ajaxSubmit({ //E nessa função enviamos o form ao servidor
//dataType: 'text', //aqui dizemos que o tipo que receberemos de retorno será um texto vindo do servidor
// 
////Mas poderia ser um JSON ou XML.... continuando
//success: function(){ //se o servidor retornou "sucesso"
//$('#loader').hide(); //escondemos a div que mostra o nosso "carregando"
//alert('Seja bem-vindo administrador!'); //e mostramos a mensagem seja bem-vindo;
//},
//error: function(){ //caso contrário se o servidor retornar um "erro"
//$('#loader').hide(); //escondemos a div "carregando..."
//alert('Usuario e/ou senha nao encontrados!'); //e dizemos que o usuário não foi encontrado
//}
//});
//return false; //aqui retornamos falso para a função submit do form. apenas para evitarmos que o form seja enviado pelo browser.
//});
