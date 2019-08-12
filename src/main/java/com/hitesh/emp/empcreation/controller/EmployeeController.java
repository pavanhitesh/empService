package com.hitesh.emp.empcreation.controller;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.hitesh.emp.empcreation.database.EmployeeInfo;
import com.hitesh.emp.empcreation.services.EmployeeDataService;

import springfox.documentation.spring.web.json.Json;


@RestController
public class EmployeeController {
	@Autowired
	EmployeeDataService employeeDataService;

	@RequestMapping(value ="/home",method=RequestMethod.GET)
	public String getApplication() {
		return "Application Running";
	}

	@RequestMapping(value ="/employeeNo",method=RequestMethod.GET)
	public Optional<EmployeeInfo> getEmployeeByNumber(@RequestParam String phoneNumber) {
		return employeeDataService.getEmployeeInfoByNumber(phoneNumber);
	}

	@RequestMapping(value ="/employeeId",method=RequestMethod.GET)
	public Optional<EmployeeInfo> getEmployeeById(@RequestParam String id) {
		return employeeDataService.getEmployeeInfoById(Long.valueOf(id));
	}

	@RequestMapping(value ="/saveEmployee",method=RequestMethod.POST)
	public JSONObject saveEmployeeInfo(@RequestBody EmployeeInfo dataInfo) {
		String message = employeeDataService.saveEmployeeInfo(dataInfo);
		JSONObject response = new JSONObject();
		response.put("message", message);
		return response;
	}

	@RequestMapping(value ="/upload",method=RequestMethod.POST)
	public String singleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "redirect:uploadStatus";
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			System.out.println(bytes.length);
			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

		} catch (IOException e) {
			e.printStackTrace();
		}

		return "redirect:/uploadStatus";
	}

	@GetMapping("/uploadStatus")
	public String uploadStatus() {
		return "uploadStatus";
	}

}
