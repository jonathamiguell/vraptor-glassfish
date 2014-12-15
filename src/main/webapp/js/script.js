function mostraDetalhe(id) {

    $.ajax({
        url: "/vraptor-glassfish/" + id + "/produto.json",
        type: 'GET',
        success: function (data) {
            console.log(data);
            var vId = $("#pID");
            var vNome = $("#pNOME");
            var vDescricao = $("#pDESCRICAO");
            var vPreco = $("#pPRECO");

            vId.html(data.produto.id);
            vNome.html(data.produto.nome);
            vDescricao.html(data.produto.descricao);
            vPreco.html(data.produto.preco);

            $("#overlay").css("visibility", "visible");
        }
    });
}
;
function  editar() {
    $('#form-edita-cadastro').show();

}

$(document).ready(function () {
    Produto.hideNewProdutoForm();
    Produto.hideEditaCadastro();

    $("#btn-novo").click(function () {
        Produto.openNewProdutoForm();
    });
    $("#btn-cancelar").click(function () {
        Produto.hideNewProdutoForm();
    });
});

$("#btn-fechar").on("click", function () {
    $("#overlay").css("visibility", "hidden");

});

var Produto = {};
Produto.hideEditaCadastro = function () {
    $('#form-edita-cadastro').hide();
};
Produto.openEditaCadastro = function () {
    $('#form-edita-cadastro').show();
};
Produto.openNewProdutoForm = function () {
    $('#form-cadastro').show();
    $('#div-btn-form').hide();
};
Produto.hideNewProdutoForm = function () {
    $('#div-btn-form').show();
    $('#form-cadastro').hide();
};
Produto.clearForm = function () {
    $("#pID").removeAttr(":disabled");
    $("#pNOME").val('');
    $("#pDESCRICAO").val('');
    $("#pPRECO").val('');


};