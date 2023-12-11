package com.grocerystore.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocerystore.project.constants.GroceryConstants;
import com.grocerystore.project.constants.RegistrationConstants;
import com.grocerystore.project.dto.GroceryDTO;
import com.grocerystore.project.exception.GroceryException;
import com.grocerystore.project.response.dto.AddGroceryResponse;
import com.grocerystore.project.response.dto.CommonResponse;
import com.grocerystore.project.response.dto.GetGroceryListResponse;
import com.grocerystore.project.response.dto.UpdateGroceryResponse;
import com.grocerystore.project.service.GroceryService;

import jakarta.annotation.Nonnull;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

	@Autowired
	GroceryService groceryService;

	@PostMapping("/add")
	public ResponseEntity<AddGroceryResponse> addGrocery(@RequestBody GroceryDTO groceryDTO)
			throws GroceryException, Exception {
		Integer id = groceryService.addGrocery(groceryDTO);
		AddGroceryResponse response = new AddGroceryResponse();
		response.setGroceryId(id);
		response.setMessage(GroceryConstants.ADD_GROCERY_SUCCESS_MESSAGE);
		response.setCode(RegistrationConstants.SUCCESS_CODE);
		return new ResponseEntity<AddGroceryResponse>(response, HttpStatus.OK);
	}

	@GetMapping("/get")
	public ResponseEntity<GetGroceryListResponse> getGroceryList(@RequestParam @Nonnull Integer userId)
			throws GroceryException, Exception {
		List<GroceryDTO> list = groceryService.getAllGroceries(userId);
		GetGroceryListResponse response = new GetGroceryListResponse();
		response.setGroceryList(list);
		response.setMessage(GroceryConstants.GROCERY_LIST_SUCCESS_MESSAGE);
		response.setCode(RegistrationConstants.SUCCESS_CODE);
		return new ResponseEntity<GetGroceryListResponse>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<UpdateGroceryResponse> updateGrocery(@RequestBody GroceryDTO groceryDTO,
			@RequestParam @Nonnull Integer userId) throws GroceryException, Exception {
		Integer grocery = groceryService.updateGrocery(groceryDTO, userId);
		UpdateGroceryResponse response = new UpdateGroceryResponse();
		response.setGroceryId(grocery);
		response.setMessage(GroceryConstants.GROCERY_UPDATE_SUCCESS_MESSAGE);
		response.setCode(RegistrationConstants.SUCCESS_CODE);
		return new ResponseEntity<UpdateGroceryResponse>(response, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<CommonResponse> deleteGrocery(@Nonnull Integer groceryId, @Nonnull Integer userId)
			throws GroceryException, Exception {
		groceryService.deleteGrocery(groceryId, userId);
		CommonResponse response = new CommonResponse();
		response.setMessage(GroceryConstants.GROCERY_DELETE_SUCCESS_MESSAGE);
		response.setCode(RegistrationConstants.SUCCESS_CODE);
		return new ResponseEntity<CommonResponse>(response, HttpStatus.OK);
	}

}
