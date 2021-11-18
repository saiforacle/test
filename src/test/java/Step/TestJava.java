package Step;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
//import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.internal.http.URIBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestJava {
	JSONObject postRequest=new JSONObject();
	JSONArray nestedRequest=new JSONArray();
	ArrayList<String> addinFinal=new ArrayList<String>();
	
	//Creation of Entity Configuration
	//Creation1
	@Given("Grain, Entity, Dataset and Measures")
	public void grain_entity_dataset_and_measures() {
		//The below are hard Coded enteries
		postRequest.put("infodom", "FSDFINFO");
		postRequest.put("mode","add");
		postRequest.put("locale", "en_US");
		postRequest.put("user", "GLUSER");
		
		
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@When("I chose Grain as {string}, Entity as {string}")
	public void i_chose_grain_as_entity_as(String grain, String entity) {
		
		postRequest.put("entityConfig_type", grain);
		postRequest.put("entityConfig_entityName", entity);
			
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("the equivalent Dataset which is {string} and Measures {string} are selected")
	public void the_equivalent_dataset_which_is_and_measures_are_selected(String Dataset, String Measures) {
	    // Write code here that turns the phrase above into concrete actions
		postRequest.put("entityConfig_dataSet", Dataset);
		ArrayList<String> s=new ArrayList<String>();
		
		s.add(Measures);
		
		postRequest.put("entityConfig_measures", s);
	}

	@Then("the response should be success i.e Response Code =  {string} for these CRUD operations")
	public void the_response_should_be_success_response_code_200ok_for_these_crud_operations(String statusCode) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Request Sent:"+postRequest.toJSONString());
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
		    HttpPost request = new HttpPost("https://138.3.96.89:8085/dev/GLRecon/EntityConfig/add");
		    StringEntity params = new StringEntity(postRequest.toJSONString());
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		    System.out.println("Params:"+params);
		    CloseableHttpResponse response1= httpClient.execute(request);
		    int i=Integer.parseInt(statusCode);
		    
		    assertThrows(null, null);
		    assertEquals(i,response1.getStatusLine().getStatusCode());
		    if(i==response1.getStatusLine().getStatusCode())
		    {
		    System.out.println("Result:Passed \n Status Line:"+response1.getStatusLine());
		    System.out.println("Body:"+EntityUtils.toString(response1.getEntity(), "UTF-8"));
		    }
		    else {
		    	System.out.println("Result:Failed \n Status Line:"+response1.getStatusLine());
		    	System.out.println("Body:"+EntityUtils.toString(response1.getEntity(), "UTF-8"));
		    }
		// handle response here...
		} catch (Exception ex) {
			ex.printStackTrace();
		    // handle exception here
		} 
		
		
	}
	
	
	//Update
		
	@Given("Grain and Entity fields are disabled and Dataset and Measures can be changed")
	public void grain_and_entity_fields_are_disabled_and_dataset_and_measures_can_be_changed() {
		
		
		postRequest.put("infodom", "FSDFINFO");
		postRequest.put("mode","update");
		postRequest.put("locale", "en_US");
		postRequest.put("user", "GLUSER");

	}

	@When("I chose Grain as {string}, Entity as {string} and chose Dataset which is {string}")
	public void i_chose_grain_as_entity_as_and_chose_dataset_which_is(String grain, String entity, String dataset) {
		postRequest.put("entityConfig_type", grain);
		postRequest.put("entityConfig_entityName", entity);
		postRequest.put("entityConfig_dataSet", dataset);
		
	}

	@When("Measures {string} are selected")
	public void measures_are_selected(String Measures) {
        ArrayList<String> s=new ArrayList<String>();
	    s.add(Measures);
	    postRequest.put("entityConfig_measures", s);
	}
	
	@Then("the response should be success i.e Response Code =  {string} for this update operation")
	public void the_response_should_be_success_response_code_200ok_for_this_update_operation(String statusCode) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Request Sent:"+postRequest.toJSONString());
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			HttpPut request = new HttpPut("http://144.25.123.6:8085/dev/GLRecon/EntityConfig/update");
			request.setHeader("Accept", "application/json");
			request.setHeader("Content-type", "application/json");
		   
		    StringEntity params = new StringEntity(postRequest.toJSONString());
		   
		    request.setEntity(params);
		    System.out.println("Params:"+params);
		    CloseableHttpResponse response1= httpClient.execute(request);
		    int i=Integer.parseInt(statusCode);
		    assertEquals(i,response1.getStatusLine().getStatusCode());
		    if(i==response1.getStatusLine().getStatusCode())
		    {
		    System.out.println("Result:Passed \n Status Line:"+response1.getStatusLine());
		    System.out.println("Body:"+EntityUtils.toString(response1.getEntity(), "UTF-8"));
		    }
		    else {
		    	System.out.println("Result:Failed \n Status Line:"+response1.getStatusLine());
		    	System.out.println("Body:"+EntityUtils.toString(response1.getEntity(), "UTF-8"));}// handle response here...
		} catch (Exception ex) {
		    // handle exception here
		} 
	}

	
	//Delete
	
	@Given("entity configurations exists in the system")
	public void entity_configurations_exists_in_the_system() {
		postRequest.put("infodom", "FSDFINFO");
	}

	@When("I chose Grain as {string} and Entity configuration for {string} and Delete the configuration")
	public void i_chose_grain_as_and_entity_configuration_for_and_delete_the_configuration(String grain, String entity) {
		postRequest.put("entityConfig_type", grain);
		postRequest.put("entityConfig_entityName", entity);
	}

	@Then("the response should be success i.e Response Code =  {string} for this delete operation")
	public void the_response_should_be_success_i_e_response_code_for_this_delete_operation(String statusCode) {
		
		System.out.println("Request Sent:"+postRequest.toJSONString());
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			RequestSpecification request= RestAssured.given();
			request.header("Content-Type","application/json");
			request.body(postRequest.toJSONString());
			Response response=request.delete("http://144.25.123.6:8085/dev/GLRecon/EntityConfig/delete");
			
		    int i=Integer.parseInt(statusCode);
		    assertEquals(i,response.getStatusCode());
		    
		    if(i==response.getStatusCode())
		    {
		    System.out.println("Result:Passed \n Status Line:"+response.getStatusLine());
		    System.out.println("Body:"+response.getBody());
		    }
		    else {
		    	System.out.println("Result:Failed \n Status Line:"+response.getStatusLine());
		    	System.out.println("Body:"+response.getBody());}// handle response here...
		} catch (Exception ex) {
		    // handle exception here
		} 
	}
	
	
	//ConfigurationType
	@Given("Source Grain, Source Entity, Target Entity, Dimensions And the dimension attributes are available to select")
	public void source_grain_source_entity_target_entity_dimensions_and_the_dimension_attributes_are_available_to_select() {
		postRequest.put("infodom", "FSDFINFO");
		postRequest.put("locale", "en_US");
		postRequest.put("user", "GLUSER");

	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("I enter a name And description for the type {string} and code as {string}")
	public void i_enter_a_name_and_description_for_the_type(String type,String code) {
	    // Write code here that turns the phrase above into concrete actions
		postRequest.put("type_Name", type);
		postRequest.put("type_Desc", type);
		postRequest.put("type_Code",code);
	}

	@When("chose Source Grain as {string}, Source Entity as {string}")
	public void chose_source_grain_as_source_entity_as(String grain, String src_entity) {
	    // Write code here that turns the phrase above into concrete actions
		postRequest.put("type_srcGrain", grain);
		postRequest.put("type_srcEntity", src_entity);
	}

	@When("Target Entity as {string} and target grain as {string}")
	public void target_entity_as(String trg_entity,String trg_grain) {
	    // Write code here that turns the phrase above into concrete actions
		postRequest.put("type_tgtGrain", trg_grain);
		ArrayList<String> trg_ent=new ArrayList<String>();
		String[] split=trg_entity.split(", ");
		for(int i=0;i<split.length;i++)
			trg_ent.add(split[i]);
		
		
		
		postRequest.put("type_tgtEntities", trg_ent);
	}
	 
	@When("select the Dimension as {string} and attribute as {string}  and dimension value as {string}")
	public void select_the_dimension_as_and_attribute_as_and_dimension_value_as(String dimension, String attribute,String dimvalue) {
		JSONObject memberRequest1=new JSONObject();
		JSONObject memberRequest2=new JSONObject();
		JSONObject memberRequest3=new JSONObject();
		JSONArray memberarray1=new JSONArray();
		JSONArray memberarray2=new JSONArray();
		JSONArray memberarray3=new JSONArray();
		
		memberRequest1.put("entityname", "Stage cards");
		memberRequest1.put("entityvalue", "STG_CARDS");
		memberRequest1.put("membername", attribute);
		memberRequest1.put("membervalue", "v_ccy_code");
		
		memberarray1.add(memberRequest1);
		
		memberRequest2.put("entityname", "Stage cards");
		memberRequest2.put("entityvalue", "STG_CARDS");
		memberRequest2.put("membername", attribute);
		memberRequest2.put("membervalue", "v_ccy_code");
		
		memberarray1.add(memberRequest2);
		
		
		memberRequest3.put("entityname", "Stage cards");
		memberRequest3.put("entityvalue", "STG_CARDS");
		memberRequest3.put("membername", attribute);
		memberRequest3.put("membervalue", "v_ccy_code");
		
		
		memberarray1.add(memberRequest3);
		
	
		
		
		JSONObject dimensionRequest=new JSONObject();
		JSONArray dimensionarray=new JSONArray();
		
		dimensionarray.add(memberRequest1);
		dimensionarray.add(memberRequest2);
		dimensionarray.add(memberRequest3);
		
		
		dimensionRequest.put("dimval",dimvalue);
		dimensionRequest.put("dimname",dimension);
		dimensionRequest.put("mrflag","M");
		dimensionRequest.put("members",dimensionarray);
		
		nestedRequest.add(dimensionRequest);
		
	}
	

	@Then("the response should be success \\(Response Code- 200OK) for these CRUD operations")
	public void the_response_should_be_success_response_code_200ok_for_these_crud_operations() {
		postRequest.put("dimensionData",nestedRequest);
		
		System.out.println("Request Sent:"+postRequest.toJSONString());
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
		
		HttpPost request = new HttpPost("http://144.25.123.6:8085/dev/GLRecon/gltypesummary/add");
		//request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
	   
	    StringEntity params = new StringEntity(postRequest.toJSONString());
	   
	    request.setEntity(params);
	    System.out.println("Params:"+params);
	    CloseableHttpResponse response1= httpClient.execute(request);
	    int i=200;
	    assertEquals(i,response1.getStatusLine().getStatusCode());
	    if(i==response1.getStatusLine().getStatusCode())
	    {
	    System.out.println("Result:Passed \n Status Line:"+response1.getStatusLine());
	    System.out.println("Body:"+EntityUtils.toString(response1.getEntity(), "UTF-8"));
	    }
	    else {
	    	System.out.println("Result:Failed \n Status Line:"+response1.getStatusLine());
	    	System.out.println("Body:"+EntityUtils.toString(response1.getEntity(), "UTF-8"));}
		
		
		}
		catch(Exception e)
		{
			System.out.println("Exception Found");
		}
	}
	
	
	//Updation in Type Configuration
	@Given("I have different Type configurations exists in the system")
	public void i_have_different_type_configurations_exists_in_the_system() {
		postRequest.put("infodom", "FSDFINFO");
		postRequest.put("locale", "en_US");
		postRequest.put("user", "GLUSER");
	}

	@When("I chose {string} type and code as {string}")
	public void i_chose_type_and_code_as(String type, String code) {
		postRequest.put("type_Name", type);
		postRequest.put("type_Desc", type);
		postRequest.put("type_Code",code);
	}

	@When("for Source Grain as {string}, Source Entity as {string}")
	public void for_source_grain_as_source_entity_as(String grain, String src_entity) {
		postRequest.put("type_srcGrain", grain);
		postRequest.put("type_srcEntity", src_entity);
		
		
	}

	@When("Update the Description of the Type configuration and select a new target entity as {string} and target grain as {string}")
	public void update_the_description_of_the_type_configuration_and_select_a_new_target_entity_as_and_target_grain_as(String trg_entity, String trg_grain) {
		postRequest.put("type_tgtGrain", trg_grain);
		ArrayList<String> trg_ent=new ArrayList<String>();
		String[] split=trg_entity.split(", ");
		for(int i=0;i<split.length;i++)
			trg_ent.add(split[i]);
		
		
		
		postRequest.put("type_tgtEntities", trg_ent);
	}

	@When("the selected Dimension is {string} and attribute as {string}  and dimension value is {string}")
	public void the_selected_dimension_is_and_attribute_as_and_dimension_value_is(String dimension, String attribute, String dimvalue) {
		JSONObject memberRequest1=new JSONObject();
		JSONObject memberRequest2=new JSONObject();
		JSONObject memberRequest3=new JSONObject();
		JSONArray memberarray1=new JSONArray();
		JSONArray memberarray2=new JSONArray();
		JSONArray memberarray3=new JSONArray();
		
		memberRequest1.put("entityname", "Stage cards");
		memberRequest1.put("entityvalue", "STG_CARDS");
		memberRequest1.put("membername", attribute);
		memberRequest1.put("membervalue", "v_ccy_code");
		
		memberarray1.add(memberRequest1);
		
		memberRequest2.put("entityname", "Stage cards");
		memberRequest2.put("entityvalue", "STG_CARDS");
		memberRequest2.put("membername", attribute);
		memberRequest2.put("membervalue", "v_ccy_code");
		
		memberarray1.add(memberRequest2);
		
		
		memberRequest3.put("entityname", "Stage cards");
		memberRequest3.put("entityvalue", "STG_CARDS");
		memberRequest3.put("membername", attribute);
		memberRequest3.put("membervalue", "v_ccy_code");
		
		
		memberarray1.add(memberRequest3);
		
	
		
		
		JSONObject dimensionRequest=new JSONObject();
		JSONArray dimensionarray=new JSONArray();
		
		dimensionarray.add(memberRequest1);
		dimensionarray.add(memberRequest2);
		dimensionarray.add(memberRequest3);
		
		
		dimensionRequest.put("dimval",dimvalue);
		dimensionRequest.put("dimname",dimension);
		dimensionRequest.put("mrflag","M");
		dimensionRequest.put("members",dimensionarray);
		
		nestedRequest.add(dimensionRequest);
		
	}

	@Then("the response should be success \\(Response Code- 200OK) for this edit operation")
	public void the_response_should_be_success_response_code_200ok_for_this_edit_operation() {
postRequest.put("dimensionData",nestedRequest);
		
		System.out.println("Request Sent:"+postRequest.toJSONString());
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		try {
		
		HttpPost request = new HttpPost("http://144.25.123.6:8085/dev/GLRecon/gltypesummary/update");
		//request.setHeader("Accept", "application/json");
		request.setHeader("Content-type", "application/json");
	   
	    StringEntity params = new StringEntity(postRequest.toJSONString());
	   
	    request.setEntity(params);
	    System.out.println("Params:"+params);
	    CloseableHttpResponse response1= httpClient.execute(request);
	    int i=200;
	    assertEquals(i,response1.getStatusLine().getStatusCode());
	    if(i==response1.getStatusLine().getStatusCode())
	    {
	    System.out.println("Result:Passed \n Status Line:"+response1.getStatusLine());
	    System.out.println("Body:"+EntityUtils.toString(response1.getEntity(), "UTF-8"));
	    }
	    else {
	    	System.out.println("Result:Failed \n Status Line:"+response1.getStatusLine());
	    	System.out.println("Body:"+EntityUtils.toString(response1.getEntity(), "UTF-8"));}
		
		
		}
		catch(Exception e)
		{
			System.out.println("Exception Found");
		}
	}

	
	//Deletion
	@Given("entity configurations exists in the system for deletion")
	public void entity_configurations_exists_in_the_system_for_deletion() {
		postRequest.put("infodom", "FSDFINFO");
		postRequest.put("locale", "en_US");
		postRequest.put("user", "GLUSER");
	    
	}

	@When("I chose the Type configuration for deletion as {string} and code is {string}")
	public void i_chose_the_type_configuration_for_deletion_as_and_code_is(String type, String code) {
		postRequest.put("type_Code", code);
	}

	@When("Delete the configuration")
	public void delete_the_configuration() {
	    System.out.println("Deleting!!!!!!");
	}

	@Then("the response should be success \\(Response Code- 200OK) for this delete operation.")
	public void the_response_should_be_success_response_code_200ok_for_this_delete_operation() {
System.out.println("Request Sent:"+postRequest.toJSONString());
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
			RequestSpecification request= RestAssured.given();
			request.header("Content-Type","application/json");
			request.body(postRequest.toJSONString());
			Response response=request.delete("http://144.25.123.6:8085/dev/GLRecon/gltypesummary/delete");
			
		    int i=200;
		    assertEquals(i,response.getStatusCode());
		    if(i==response.getStatusCode())
		    {
		    System.out.println("Result:Passed \n Status Line:"+response.getStatusLine());
		    System.out.println("Body:"+response.getBody());
		    }
		    else {
		    	System.out.println("Result:Failed \n Status Line:"+response.getStatusLine());
			    System.out.println("Body:"+response.getBody());}
		    // handle response here...
		} catch (Exception ex) {
		    // handle exception here
		}
	}
		
		///////Adjustment////////////
		
		@Given("1the Entity {string} and the attribute {string} is present with Adjustment Entity using {string}")
			public void the_entity_and_the_attribute_is_present(String string1, String string2, String string3) {
			postRequest.put("entity","Stage Cards");
			postRequest.put("attribute","Account Branch Code");
			postRequest.put("adjustment entity","stage cards");
			postRequest.put("name","Test Prod");
			postRequest.put("desc", "test 202");
			postRequest.put("type", "ADJ-OTH");
			postRequest.put("assignType", "E");
			postRequest.put("entity", "STG_CARDS");
			postRequest.put("dq", "");
			postRequest.put("report", "");
			postRequest.put("condition", "1=1");
			postRequest.put("schedule", "");
			postRequest.put("dataset", "");
			postRequest.put("comment","Test 20 Comments");
			JSONObject postRequest1=new JSONObject();
			JSONArray ja=new JSONArray();
			postRequest1.put("targetAttribute", "STG_CARDS.V_BRANCH_CODE");
			postRequest1.put("targetExpression", "Test");
			postRequest1.put("expressionPhy", "");
			postRequest1.put("dataType", "String");
			ja.add(postRequest1);
			postRequest.put("ruleDriven", ja);
		}


		@When("1I chose Entity as {string} and enter the Name as {string}, description as {string} and select the attribute as {string} and the Target Expression as {string}")
		public void i_chose_entity_as_and_enter_the_name_as_description_as_and_select_the_attribute_as_and_the_target_expression_as1(String string, String string2, String string3, String string4, String string5) {
			postRequest.put("entity","Stage Cards");
			postRequest.put("name","Test Prod1");
			postRequest.put("description","test 202");
			postRequest.put("attribute","Account Branch Code");
			postRequest.put("target_expression","MUM");
		} 

		@Then("1create the response should be\\(Response Code- 200OK) for these CRUD operations")
		public void the_response_should_be_response_code_200ok_for_these_crud_operations1() throws Throwable, Throwable {
			postRequest.put("msgCode", "DCAF0000");
			postRequest.put("msgBody", "S");
			System.out.println("Request Sent:"+postRequest.toJSONString());
			CloseableHttpClient httpClient=HttpClientBuilder.create().build(); 
			HttpPost request=new HttpPost("http://144.25.123.6:8085/dev/dcaf/adjustments/v1");
			StringEntity s=new StringEntity(postRequest.toJSONString());
			request.addHeader("content-type","application/json");
			request.setEntity(s);
			System.out.println("Params:"+s);
			CloseableHttpResponse response1= httpClient.execute(request);
			int i =Integer.parseInt("200");
			assertEquals(i,response1.getStatusLine().getStatusCode());
			System.out.println("Result passed \n Status Line:"+response1.getStatusLine());
		}

		//2.create
		@Given("2the Entity {string} and the attribute2 {string} is present with Adjustment Entity using {string}")
		public void the_entity_and_the_attribute2_is_present(String string, String string2, String string3) {
			postRequest.put("entity","Stage Cards");
			postRequest.put("attribute","Application Number");
			postRequest.put("adjustment entity","stage cards");
			postRequest.put("name","Test Prod");
			postRequest.put("desc", "test 202");
			postRequest.put("type", "ADJ-OTH");
			postRequest.put("assignType", "E");
			postRequest.put("entity", "STG_CARDS");
			postRequest.put("dq", "");
			postRequest.put("report", "");
			postRequest.put( "condition", "1=1");
			postRequest.put("schedule", "");
			postRequest.put( "dataset", "");
			postRequest.put( "comment","Test 20 Comments");
			JSONObject postRequest1=new JSONObject();
			JSONArray ja=new JSONArray();
			postRequest1.put("targetAttribute", "STG_CARDS.V_BRANCH_CODE");
			postRequest1.put("targetExpression", "1000");
			postRequest1.put("expressionPhy", "");
			postRequest1.put("dataType", "Number");
			ja.add(postRequest1);
			postRequest.put("ruleDriven", ja);
		}

		@When("2I chose Entity as {string} and enter the Name as {string}, description as {string} and select the attribute as {string} and the Target Expression as {string}")
		public void i_chose_entity_as_and_enter_the_name_as_description_as_and_select_the_attribute_as_and_the_target_expression_as2(String string, String string2, String string3, String string4, String string5) {
			postRequest.put("entity","Stage Cards");
			postRequest.put("name","Test Prod2");
			postRequest.put("description","test 202");
			postRequest.put("attribute","Application Number");
			postRequest.put("target_expression","25"); 

		}

		@Then("2create the response should be \\(Response Code- 200OK) for these CRUD operations")
		public void the_response_should_be_response_code_200ok_for_these_crud_operations2() throws Throwable, Throwable {
			postRequest.put("msgCode", "DCAF0000");
			postRequest.put("msgBody", "S");
			System.out.println("Request Sent:"+postRequest.toJSONString());
			CloseableHttpClient httpClient=HttpClientBuilder.create().build(); 
			HttpPost request=new HttpPost("http://144.25.123.6:8085/dev/dcaf/adjustments/v1");
			StringEntity s=new StringEntity(postRequest.toJSONString());
			request.addHeader("content-type","application/json");
			request.setEntity(s);
			System.out.println("Params:"+s);
			CloseableHttpResponse response1= httpClient.execute(request);
			int i =Integer.parseInt("200");
			assertEquals(i,response1.getStatusLine().getStatusCode());
			System.out.println("Result passed \n Status Line:"+response1.getStatusLine());
		}

		//3.create
		@Given("3the Entity {string} and the attribute3 {string} is present with Adjustment Entity using {string}")
		public void the_entity_and_the_attribute3_is_present(String string, String string2, String string3) {
			postRequest.put("entity","Stage Cards");
			postRequest.put("attribute","Account Close Date");
			postRequest.put("name","Test Prod");
			postRequest.put("desc", "test 202");
			postRequest.put("type", "ADJ-OTH");
			postRequest.put("assignType", "E");
			postRequest.put("entity", "STG_CARDS");
			postRequest.put("dq", "");
			postRequest.put("report", "");
			postRequest.put( "condition", "1=1");
			postRequest.put("schedule", "");
			postRequest.put( "dataset", "");
			postRequest.put( "comment","Test 20 Comments");
			JSONObject postRequest1=new JSONObject();
			JSONArray ja=new JSONArray();
			postRequest1.put("targetAttribute", "STG_CARDS.V_BRANCH_CODE");
			postRequest1.put("targetExpression", "'2021-05-05'");
			postRequest1.put("expressionPhy", "");
			postRequest1.put("dataType", "Date");
			ja.add(postRequest1);
			postRequest.put("ruleDriven", ja);
		}

		@When("3I chose Entity as {string} and enter the Name as {string}, description as {string} and select the attribute as {string} and the Target Expression as {string}")
		public void i_chose_entity_as_and_enter_the_name_as_description_as_and_select_the_attribute_as_and_the_target_expression_as(String string, String string2, String string3, String string4, String string5) {
			postRequest.put("entity","Stage Cards");
			postRequest.put("name","Test Prod2");
			postRequest.put("description","test 202");
			postRequest.put("attribute","Account Close Date");
			postRequest.put("target_expression","to_date('12/31/2020','mm/dd/yyyy')"); 
		}

		@Then("3create the response should be \\(Response Code- 200OK) for these CRUD operations")
		public void the_response_should_be_response_code_200ok_for_these_crud_operations() throws Throwable, Throwable {
			postRequest.put("msgCode", "DCAF0000");
			postRequest.put("msgBody", "S");
			System.out.println("Request Sent:"+postRequest.toJSONString());
			CloseableHttpClient httpClient=HttpClientBuilder.create().build(); 
			HttpPost request=new HttpPost("http://144.25.123.6:8085/dev/dcaf/adjustments/v1");
			StringEntity s=new StringEntity(postRequest.toJSONString());
			request.addHeader("content-type","application/json");
			request.setEntity(s);
			System.out.println("Params:"+s);
			CloseableHttpResponse response1= httpClient.execute(request);
			int i =Integer.parseInt("200");
			assertEquals(i,response1.getStatusLine().getStatusCode());
			System.out.println("Result passed \n Status Line:"+response1.getStatusLine());

		}

		//4.getall
		@Given("4getall Adjustment Rules exists in the system")
		public void getall_adjustment_rules_exists_in_the_system() {
			postRequest.put("msgCode", "DCAF0000");
			JSONObject postRequest1=new JSONObject();
			JSONArray ja1=new JSONArray();
			postRequest1.put("id", "101");
			postRequest1.put("name", "Test 21 sept");
			postRequest1.put("description", "Testing updatee");
			postRequest1.put("comments", "Test 20 Comments");
			postRequest1.put("type", "ADJ-OTH");
			postRequest1.put("accessType", "R/W");
			postRequest1.put("frequency", "");
			postRequest1.put("sourceTable", "STG_CARDSS");
			postRequest1.put("effectiveFrom", "");
			postRequest1.put("effectiveTo", "");
			postRequest1.put("isExported", "N");
			postRequest1.put("assignType", "M");
			postRequest1.put("filter", "2=2");
			postRequest1.put("actionKey", "");
			JSONObject postRequest2=new JSONObject();
			JSONArray ja2=new JSONArray();
			postRequest2.put("id", "102");
			postRequest2.put("name", "Test 211 sept");
			postRequest2.put("description", "test 202");
			postRequest2.put("comments", "Test 20 Comments");
			postRequest2.put("type", "ADJ-OTH");
			postRequest2.put("accessType", "R/W");
			postRequest2.put("frequency", "");
			postRequest2.put("sourceTable", "STG_CARDS");
			postRequest2.put("effectiveFrom", "");
			postRequest2.put("effectiveTo", "");
			postRequest2.put("isExported", "N");
			postRequest2.put("assignType", "E");
			postRequest2.put("filter", "1=1");
			postRequest2.put("actionKey", "");
			ja2.add(postRequest2);
			ja1.add(postRequest1);
			postRequest.put("msgBody",ja1);
			postRequest.put("msgBody",ja2);
		}

		@When("I select Adjustment Rules and  click on save")
		public void i_select_adjustment_rules_and_click_on_save() {

		}

		@Then("4getall the response should be \\(Response Code- 200OK) for these CRUD operations")
		public void the_response_should_be_name_test_sept_description_test_comments_test_comments_type_adj_oth_access_type_r_w_frequency_source_table_stg_cards_effective_from_effective_to_is_exported_n_assign_type_e_filter_action_key_response_code_200ok_for_these_crud_operations() throws Throwable, Throwable {
			System.out.println("Request Sent:"+postRequest.toJSONString());
			CloseableHttpClient httpClient=HttpClientBuilder.create().build(); 
			HttpPost request=new HttpPost("http://144.25.123.6:8085/dev/dcaf/adjustments/v1");
			StringEntity s=new StringEntity(postRequest.toJSONString());
			request.addHeader("content-type","application/json");
			request.setEntity(s);
			System.out.println("Params:"+s);
			CloseableHttpResponse response1= httpClient.execute(request);
			int i =Integer.parseInt("200");
			assertEquals(i,response1.getStatusLine().getStatusCode());
			System.out.println("Result passed \n Status Line:"+response1.getStatusLine());

		}

		//5.get
		@Given("5get Adjustment Rules exists in the system")
		public void get_adjustment_rules_exists_in_the_system() {
			postRequest.put("msgCode", "DCAF0000");
			JSONObject postRequest1=new JSONObject();
			JSONArray ja1=new JSONArray();
			postRequest1.put("id", "101");
			postRequest1.put("name", "Test 21 sept");
			postRequest1.put("description", "Testing updatee");
			postRequest1.put("comments", "Test 20 Comments");
			postRequest1.put("type", "ADJ-OTH");
			postRequest1.put("accessType", "R/W");
			postRequest1.put("frequency", "");
			postRequest1.put("sourceTable", "STG_CARDSS");
			postRequest1.put("effectiveFrom", "");
			postRequest1.put("effectiveTo", "");
			postRequest1.put("isExported", "N");
			postRequest1.put("assignType", "M");
			postRequest1.put("filter", "2=2");
			postRequest1.put("actionKey", "");
			JSONObject postRequest2=new JSONObject();
			JSONArray ja2=new JSONArray();
			postRequest2.put("seq", "0");
			postRequest2.put("expression", "Lookup:{Test111Cpy}{Product Surrogate Key,Credit Line Type Surrogate Key}{AttrOne}");
			postRequest2.put("sourceColumn", "STG_CARDS.V_BRANCH_CODEE");
			postRequest2.put("expValue", "LKP:[LKP_10010][L100102V1]{L100102A1:Product Surrogate Key,L100102A2:Credit Line Type Surrogate Key}");
			postRequest2.put("dataType", "String");
			JSONArray ja3=new JSONArray();
			postRequest2.put("seq", "1");
			postRequest2.put("expression", "Lookup:{Test111Cpy}{Product Surrogate Key,Credit Line Type Surrogate Key}{AttrOne}");
			postRequest2.put("sourceColumn", "STG_CARDS.V_BRANCH_CODEE");
			postRequest2.put("expValue", "LKP:[LKP_10010][L100102V1]{L100102A1:Product Surrogate Key,L100102A2:Credit Line Type Surrogate Key}");
			postRequest2.put("dataType", "String");
			ja2.add(postRequest2);
			ja3.add(postRequest2);
			postRequest1.put("expressions", ja2);
			postRequest1.put("expressions", ja3);
			ja1.add(postRequest1);
			postRequest.put("msgBody", ja1);
		}

		@When("I select an Adjustment Rule for Stage Cards  and  click on save")
		public void i_select_an_adjustment_rule_for_stage_cards_and_click_on_save() {

		}

		@Then("5get the response should be \\(Response Code- 200OK) for these CRUD operations")
		public void the_response_should_be_response_code_200ok_for_these_crud_operations11() throws Throwable, Throwable {
			postRequest.put("msgCode", "DCAF0000");
			postRequest.put("msgBody", "S");
			System.out.println("Request Sent:"+postRequest.toJSONString());
			CloseableHttpClient httpClient=HttpClientBuilder.create().build(); 
			HttpPost request=new HttpPost("http://144.25.123.6:8085/dev/dcaf/adjustments/v1");
			StringEntity s=new StringEntity(postRequest.toJSONString());
			request.addHeader("content-type","application/json");
			request.setEntity(s);
			System.out.println("Params:"+s);
			CloseableHttpResponse response1= httpClient.execute(request);
			int i =Integer.parseInt("200");
			assertEquals(i,response1.getStatusLine().getStatusCode());
			System.out.println("Result passed \n Status Line:"+response1.getStatusLine());

		}

		//6.delete
		@Given("6delete Adjustment Rules exists in the system")
		public void delete_adjustment_rules_exists_in_the_system() {
			postRequest.put("msgCode", "DCAF0000");
			postRequest.put("msgBody", "S");
		}

		@When("I select an Adjustment Rule with Entity as {string}, attribute {string}  and  click on save")
		public void i_select_an_adjustment_rule_with_entity_as_attribute_and_click_on_save(String string, String string2) {
			postRequest.put("entity", "Stage cards");
			postRequest.put("attribute", "Account Branch Code");
		}

		@Then("6delete the response should be \\(Response Code- 200OK) for these CRUD operations")
		public void delete_the_response_should_be_response_code_200ok_for_these_crud_operations() throws Throwable, Throwable {
			System.out.println("Request Sent:"+postRequest.toJSONString());
			CloseableHttpClient httpClient=HttpClientBuilder.create().build(); 
			HttpPost request=new HttpPost("http://144.25.123.6:8085/dev/dcaf/adjustments/v1");
			StringEntity s=new StringEntity(postRequest.toJSONString());
			request.addHeader("content-type","application/json");
			request.setEntity(s);
			System.out.println("Params:"+s);
			CloseableHttpResponse response1= httpClient.execute(request);
			int i =Integer.parseInt("200");
			assertEquals(i,response1.getStatusLine().getStatusCode());
			System.out.println("Result passed \n Status Line:"+response1.getStatusLine());

		}

		//7.update
		@Given("Adjustment Rule with Entity as {string}, attribute {string} ,Request Type as {string} and ID as {string} is present")
		public void adjustment_rule_with_entity_as_attribute_request_type_as_and_id_as_is_present(String string, String string2, String string3, String string4) {
			postRequest.put("entity","Stage Cards");
			postRequest.put("attribute","Account Branch Code");
			postRequest.put("request_type","PUT");
			postRequest.put("ID","101");
			postRequest.put("desc", "Testing Prod  updateeing");
			postRequest.put("comment", "Prod comment");   
			JSONObject postRequest1=new JSONObject();
			JSONArray ja1=new JSONArray();
			postRequest1.put("targetAttribute", "STG_CARDS.V_BRANCH_CODEE");
			postRequest1.put("targetExpression", "Lookup:{Test111Cpy}{Product Surrogate Key,Credit Line Type Surrogate Key}{AttrOne}");
			postRequest1.put("expressionPhy", "LKP:[LKP_10010][L100102V1]{L100102A1:Product Surrogate Key,L100102A2:Credit Line Type Surrogate Key}");
			postRequest1.put("dataType", "String");
			JSONObject postRequest2=new JSONObject();
			JSONArray ja2=new JSONArray();
			postRequest2.put("targetAttribute", "STG_CARDS.V_BRANCH_NAME");
			postRequest2.put("targetExpression", "Lookup:{Test111Cpy}{Product Surrogate Key,Credit Line Type Surrogate Key}{AttrTwoThree}");
			postRequest2.put("expressionPhy", "LKP:[LKP_10010][L100102V1]{L100102A1:Product Surrogate Key,L100102A2:Credit Line Type Surrogate Key}");
			postRequest2.put("dataType", "String");
			ja2.add(postRequest2);
			ja1.add(postRequest1);
			postRequest.put(postRequest1, ja1);
			postRequest.put(postRequest1, ja2);


		}

		@When("I chose a Rule with Entity as {string},attribute {string} and  request type as {string} , ID as {string} and select Account Branch code with an expression as {string}  and select Application Number with an expression as {string}  and click on save")
		public void i_chose_a_rule_with_entity_as_attribute_and_request_type_as_id_as_and_select_account_branch_code_with_an_expression_as_and_select_application_number_with_an_expression_as_and_click_on_save(String string, String string2, String string3, String string4, String string5, String string6) {
			postRequest.put("entity","Stage Cards");
			postRequest.put("attribute","Account Branch Code");
			postRequest.put("request_type","PUT");
			postRequest.put("ID","101");
			postRequest.put("Account_Branch_Code_expr","test");
			postRequest.put("Application_number_expr", "25");
		}

		@Then("7update the response should be \\(Response Code- 200OK) for these CRUD operations")
		public void update_the_response_should_be_response_code_200ok_for_these_crud_operations() throws Throwable, Throwable {
			postRequest.put("msgCode", "DCAF0000");
			postRequest.put("msgBody", "S");
			System.out.println("Request Sent:"+postRequest.toJSONString());
			CloseableHttpClient httpClient=HttpClientBuilder.create().build(); 
			HttpPut request=new HttpPut("http://144.25.123.6:8085/dev/dcaf/adjustments/v1");
			StringEntity s=new StringEntity(postRequest.toJSONString());
			request.addHeader("content-type","application/json");
			request.setEntity(s);
			System.out.println("Params:"+s);
			CloseableHttpResponse response1= httpClient.execute(request);
			int i =Integer.parseInt("200");
			assertEquals(i,response1.getStatusLine().getStatusCode());
			System.out.println("Result passed \n Status Line:"+response1.getStatusLine());
		}
	
	

	
}
