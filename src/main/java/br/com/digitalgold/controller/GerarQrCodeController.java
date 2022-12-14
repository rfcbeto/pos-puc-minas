package br.com.digitalgold.controller;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import br.com.digitalgold.data.dto.ProdutoQrCodeDTO;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

@RestController
@RequestMapping(path="/api/v1/qrCode")
public class GerarQrCodeController {

	@GetMapping(value = "/{texto}")
	public BufferedImage generateQrCodeImage(@PathVariable("texto") String qrText) throws Exception {
		
		MultiFormatWriter qrCodeWriter = new MultiFormatWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(qrText, BarcodeFormat.QR_CODE, 70, 70);
		
		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	@PostMapping
	public ResponseEntity<List<ProdutoQrCodeDTO>> generateQrCodeImage(@RequestBody List<ProdutoQrCodeDTO> produtosQrCodeDTO) throws Exception {
		
		List<BufferedImage> listaQrCode = new ArrayList<>();
		
		for (ProdutoQrCodeDTO produtoQrCodeDTO : produtosQrCodeDTO) {
			StringBuilder sb = new StringBuilder();
			sb.append(produtoQrCodeDTO.getCodigo());
			produtoQrCodeDTO.setCodigo(produtoQrCodeDTO.getCodigo() + "-123");
			sb.append("-123");
			sb.append("\n");
			sb.append(produtoQrCodeDTO.getDescricao());
			sb.append("\n");
			sb.append(produtoQrCodeDTO.getValor());
			
			MultiFormatWriter multiWriter = new MultiFormatWriter();
			BitMatrix bitMatrix = multiWriter.encode(sb.toString(), BarcodeFormat.QR_CODE, 70, 70);
			listaQrCode.add(MatrixToImageWriter.toBufferedImage(bitMatrix));
		}
		
		
		return new ResponseEntity<List<ProdutoQrCodeDTO>>(produtosQrCodeDTO, HttpStatus.OK); 
	}
	
	@GetMapping(value = "/{barcode}", produces = MediaType.IMAGE_PNG_VALUE)
	public static BufferedImage generateEAN13BarcodeImage(@PathVariable("barcode") String barcodeText) throws Exception {
	    //EAN13Writer barcodeWriter = new EAN13Writer();
	    
	    MultiFormatWriter multiWriter = new MultiFormatWriter();
	    BitMatrix bitMatrix = multiWriter.encode(barcodeText, BarcodeFormat.UPC_E, 50, 30);
	    // MatrixToImageWriter.toBufferedImage(bitMatrix, null);
	    return  MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	@GetMapping(value = "/{barcodeText}", produces = MediaType.IMAGE_PNG_VALUE)
	public static BufferedImage generateEAN13BarcodeImageTeste(@PathVariable("barcodeText") String barcodeText) throws Exception {
	    Barcode barcode = BarcodeFactory.createRandomWeightUPCA(barcodeText);
	    barcode.setBarHeight(35);
        barcode.setBarWidth(1);
        barcode.setName("Nome");
	    barcode.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
	    barcode.setLabel("TESTE");

	    System.out.println(barcode.getLabel());
	    System.out.println(barcode.getName());
	    return BarcodeImageHandler.getImage(barcode);
	}
}
