package com.Bridelabz.RestAssureAPIJSON;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
/*
 * Rest Assure JSON Application
 */

public class JSON {

    //Post API
    @Test
    public void postRequest(){
        System.out.println("--------------------Create new Post--------------------");
        Response response = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\"id\":\"15\",\n\"title\":\"post revirew\",\n\"author\":\"Divya\"}")
                .when()
                .post("http://localhost:3000/posts/");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
    }

    @Test
    public void getRequest(){
        System.out.println("--------------------Get Posts--------------------");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("http://localhost:3000/posts/");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void updateRequest(){
        System.out.println("--------------------Update Post--------------------");
        Response response = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\"id\":\"1\",\n\"title\":\"json-server\",\n\"author\":\"Week\"}")
                .when()
                .put("http://localhost:3000/posts/1");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void deleteRequest(){
        System.out.println("--------------------Delete Post--------------------");
        Response response = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .when()
                .delete("http://localhost:3000/posts/8");
        System.out.println("Deleted successfully.");
        response.then().assertThat().statusCode(200);
    }


    @Test
    public void getRequestForPostsWithId(){
        System.out.println("--------------------Get Posts using id--------------------");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("id", "2")
                .when()
                .get("http://localhost:3000/posts?id={id}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    //Comments API
    @Test
    public void createNewComment(){
        System.out.println("--------------------Create new comment--------------------");
        Response response = RestAssured.given()
                .accept("application/json")
                .contentType("application/json")
                .body("{\"id\":\"6\",\n\"body\":\"some comment\",\n\"postId\":\"2\"}")
                .when()
                .post("http://localhost:3000/comments/");
        response.prettyPrint();
        response.then().assertThat().statusCode(201);
    }

    @Test
    public void getRequestForComments(){
        System.out.println("--------------------Get Comments--------------------");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get("http://localhost:3000/comments");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void getCommentsUsingPostId(){
        System.out.println("--------------------Get Comments using postId--------------------");
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("postId", "2")
                .when()
                .get("http://localhost:3000/comments?postId={postId}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
    }
}
