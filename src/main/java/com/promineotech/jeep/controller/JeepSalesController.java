package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.jeep.entity.Jeep;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RequestMapping("/jeeps")//spring is going to map all requests/jeeps to JeepSalesController class
@OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"), servers = {
    @Server(url = "http://localhost: 8080", description = "local server.")})

public interface JeepSalesController {
  // @formatter:off
  @Operation( //told API about the parameters
      summary = "Return a list of Jeeps",
      description = "Return a list of Jeeps an optimal model and/or trim",
      responses = {
          @ApiResponse(responseCode = "200",
          description = "A list of Jeeps is returned", 
          content = @Content(mediaType = "application/json", 
          schema = @Schema(implementation = Jeep.class) )),
          @ApiResponse(responseCode = "400", 
          description = "The request parameters are invalid", 
          content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "404",
          description = "No Jeeps were found wht the input criteria",
          content = @Content(mediaType = "application/json")),
          @ApiResponse(responseCode = "500", 
          description = "An unplanne error occured", 
          content = @Content(mediaType = "application/json"))
      },
          parameters = {
              @Parameter(name = "model", allowEmptyValue = false, 
                  required = false, 
                  description = "The model name (i.e, 'WRANGLER')"),
              @Parameter(name = "trim", allowEmptyValue = false,
              description = "The trim level (i.e, 'SPORT')")
      }
    )
  //told spring about the parameters
  @GetMapping //Spring going to map get request at slash jeeps to the fetch jeeps method
  //and return a response status of ok or 200 if it's successful
  @ResponseStatus(code = HttpStatus.OK)
  List<Jeep> fetchJeeps(
      @RequestParam(required = false) 
          String model, 
      @RequestParam(required = false) 
          String trim);
//@formatter:on
}
