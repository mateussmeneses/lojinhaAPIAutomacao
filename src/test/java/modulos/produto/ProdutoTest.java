package modulos.produto;

import dataFactory.ProdutoDataFactory;
import dataFactory.UsuarioDataFactory;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@DisplayName("Testes de API REST do módulo de Produto")
public class ProdutoTest {

    private String token;

    @BeforeEach

    public void beforeEach() {  // Configurando os da API REST   da Lojinha
        baseURI = "http://165.227.93.41";
        basePath = "/lojinha";


        // Obter o token do usuário admin
        this.token = given()
                .contentType(ContentType.JSON)
                .body(UsuarioDataFactory.criarUsuarioAdministrador())
                .when()
                .post("/v2/login")
                .then()
                .extract()
                .path("data.token");

    }



    @Test
    @DisplayName("validar que o do valor do produto igual a 0.00 não é permitido")
    public void testValidarLimitesZeradoProibididoValorProduto() {


        System.out.println(token);

        // Tentar inserir um produto com valor 0.00 e validar que a mensagem de erro foi apresentada e o status code foi retornado 422
        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(0.00))
        .when()
                .post("/v2/produtos")
        .then()
                .assertThat()
                     .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);






    }
    @Test
    @DisplayName("validar que o do valor do produto igual a 7000.01 não é permitido")
    public void testValidarLimitesMaiorSeteMilProibididoValorProduto() {


        // Tentar inserir um produto com valor 7000.01 e validar que a mensagem de erro foi apresentada e o status code foi retornado 422

        given()
                .contentType(ContentType.JSON)
                .header("token",this.token)
                .body(ProdutoDataFactory.criarProdutoComumComOValorIgualA(7000.01))
                .when()
                .post("/v2/produtos")
                .then()
                .assertThat()
                .body("error", equalTo("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00"))
                .statusCode(422);






    }
}
