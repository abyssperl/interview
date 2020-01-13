package controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import models.Receipe;
import services.ReceipeService;

@RestController
public class ReceipeController {

	@Autowired
	ReceipeService receipeService;

	@RequestMapping(value="/findAllReceipes", method = RequestMethod.GET)
	@ResponseBody
	public List<Receipe> getAllReceipes() {
		try {
			return receipeService.listAllReceipes();
		} catch (SQLException sqle) {
			System.err.println(sqle.toString());
		}
		return new ArrayList<>();
	}

	@RequestMapping(value="/findAReceipe/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<Receipe> getAReceipe(@PathVariable("name") String name) {
		try {
			return receipeService.searchForReceipe(name);
		} catch (SQLException sqle) {
			System.err.println(sqle.toString());
		}
		return new ArrayList<>();
	}

}
