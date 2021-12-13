package tn.esprit.spring.controller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.configuration.MediaTypeUtils;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.FournisseurRepository;
 import tn.esprit.spring.service.pdfService;

 @RequestMapping("/fournisseurs")
 @RestController
 @CrossOrigin(origins="http://localhost:4200")
public class pdfController {
	@Autowired
    FournisseurRepository fRepository;
	@Autowired
	pdfService exportPdfService;


    @RequestMapping("/pdfDownload")
    public void downloadPdfFile(HttpServletResponse response) throws IOException {
    	List<Fournisseur> fournisseurs = (List<Fournisseur>)fRepository.findAll();
        ByteArrayInputStream byteArrayInputStream = exportPdfService.exportPDF(fournisseurs);
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "inline; filename=fournisseurs.pdf");
        IOUtils.copy(byteArrayInputStream, response.getOutputStream());
    }

}
