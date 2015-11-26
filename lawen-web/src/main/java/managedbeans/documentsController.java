/*
 * CAMBIOS A ARREGLAR:
 * 
 * linea 1707, 1729 CAMBIOS EN OBESIDAD ELIMINADA Y METODO GETETAPA3
 */
package managedbeans;

import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.Paragraph;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import managedbeans.adultoMayor.censo.CensoSeccionA;
import managedbeans.adultoMayor.censo.CensoSeccionB;
import managedbeans.adultoMayor.censo.CensoSeccionC;
import managedbeans.adultoMayor.censo.CensoSeccionD;
import managedbeans.adultoMayor.censo.CensoSeccionE;
import managedbeans.adultoMayor.censo.CensoSeccionF;
import managedbeans.adultoMayor.censo.ConsultasCenso;
import managedbeans.cardiovascular.censo.CensoCCVSeccionA;
import managedbeans.cardiovascular.censo.CensoCCVSeccionB;
import managedbeans.cardiovascular.censo.CensoCCVSeccionC;
import managedbeans.cardiovascular.censo.ConsultasCensoCCV;
import managedbeans.cardiovascular.censonorem.CensoCCVnoREM;
import managedbeans.cardiovascular.censonorem.ConsultasCensoCCVnoREM;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellUtil;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
/**
 *
 * @author daniel
 */
@Named(value = "documentsController" )
@ApplicationScoped
public class documentsController {
    @Inject
    private  ConsultasCenso cons;
    
    @Inject
    private  ConsultasCensoCCV consCVV;
    
    @Inject
    private  ConsultasCensoCCVnoREM consCVVnoREM;
    
    private StreamedContent file;

    public void descargaAnexoA() throws IOException, BadElementException, DocumentException {    
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/demo/images/anexo_01_psam_EFAM.pdf");
        file = new DefaultStreamedContent(stream, "image/jpg", "anexo_01_psam_EFAM.pdf");
        
    }
    public void descargaAnexoB(Object document) throws IOException, BadElementException, DocumentException {    
        InputStream stream = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/resources/documents/anexos/anexo_02_psam_BARTHEL.pdf");
        file = new DefaultStreamedContent(stream, "file/pdf", "anexo_02_psam_BARTHEL.pdf");
    }
    
    public StreamedContent getFile() {
        return file;
    }
    public void preProcessExcel(){
        
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja1 = libro.createSheet("Censo Adulto Mayor");
        
        List<CensoSeccionA> censo = cons.getElementos();
        List<CensoSeccionA> censoA1 = cons.getA1elementos();
        List<CensoSeccionB> censoB = cons.getB_elementos();
        List<CensoSeccionC> censoC = cons.getC_elementos();
        List<CensoSeccionD> censoD = cons.getD_elementos();
        List<CensoSeccionE> censoE = cons.getE_elementos();
        List<CensoSeccionF> censoF = cons.getF_elementos();
        
        HSSFRow fila = hoja1.createRow(0);
        HSSFCell celda = fila.createCell(0);
        String txt = "REM-P5.  POBLACIÓN EN CONTROL PROGRAMA DE SALUD DEL ADULTO MAYOR";
        celda.setCellValue(txt);
       
        
        HSSFCellStyle cellStyle = libro.createCellStyle();
        cellStyle = libro.createCellStyle();
        HSSFFont hSSFFont = libro.createFont();
        //hSSFFont.setFontName(HSSFFont.FONT_ARIAL);
        hSSFFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //hSSFFont.setColor(HSSFColor.GREEN.index);
        cellStyle.setFont(hSSFFont);
        celda.setCellStyle(cellStyle);
        CellUtil.setAlignment(celda, libro, CellStyle.ALIGN_CENTER);
        hoja1.addMergedRegion(new CellRangeAddress(0,0,0,15));
        
        fila = hoja1.createRow(1);
        celda = fila.createCell(0);
        txt = "SECCION A:  POBLACIÓN EN CONTROL POR CONDICIÓN DE FUNCIONALIDAD";
        celda.setCellValue(txt);
        
        
        // Columna derecha
        fila = hoja1.createRow(2);
        celda = fila.createCell(0);
        txt = "CONDICIÓN DE FUNCIONALIDAD";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(3);
        celda = fila.createCell(0);
        txt = "Autovalente sin Riesgo";
        
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(4);
        celda = fila.createCell(0);
        txt = "Autovalente con Riesgo";
        
        celda.setCellValue(txt);
        fila = hoja1.createRow(5);
        celda = fila.createCell(0);
        txt = "Riesgo de dependencia";
        
      
        celda.setCellValue(txt);
        fila = hoja1.createRow(6);
        celda = fila.createCell(0);
        txt = "SubTotal Efam";
        
        celda.setCellValue(txt);
        fila = hoja1.createRow(7);
        celda = fila.createCell(0);
        txt = "Dependencia Leve";
        
        celda.setCellValue(txt);
        fila = hoja1.createRow(8);
        celda = fila.createCell(0);
        txt = "Dependencia Moderado";
        
        celda.setCellValue(txt);
        fila = hoja1.createRow(9);
        celda = fila.createCell(0);
        txt = "Dependencia Grave";
        
        celda.setCellValue(txt);
        fila = hoja1.createRow(10);
        celda = fila.createCell(0);
        txt = "Dependencia Total";
        
        celda.setCellValue(txt);
        fila = hoja1.createRow(11);
        celda = fila.createCell(0);
        txt = "SubTotal Barthel";
        
        celda.setCellValue(txt);
        fila = hoja1.createRow(12);
        celda = fila.createCell(0);
        txt = "Total adulto mayores en control";
        celda.setCellValue(txt);
        
        hoja1.autoSizeColumn(0);
        
        
        // Fila arriba
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(1);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(1);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(4);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(4);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(5);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(5);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(6);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(6);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(7);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(7);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(8);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(9);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(10);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(10);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(10);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(11);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(11);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(11);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(12);
        txt = "Pueblos";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(12);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(12);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(13);
        txt = "Originarios";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(13);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(13);
        
        int filas=1;
        for (CensoSeccionA censoIt : censo) {
            
            fila = hoja1.getRow(3);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getContadorAutovalenteSinRiesgo());
            
            fila = hoja1.getRow(4);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getContadorAutovalenteConRiesgo());
            
            fila = hoja1.getRow(5);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getContadorRiesgoDependencia());
            
            fila = hoja1.getRow(6);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getSubTotalEfam());
            
            fila = hoja1.getRow(7);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getDependentienteLeve());
            
            fila = hoja1.getRow(8);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getDependientemoderado());
            
            
            fila = hoja1.getRow(9);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getDependientegrave());
            
            fila = hoja1.getRow(10);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getDependienteTotal());
            
            
            fila = hoja1.getRow(11);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getSubTotalBarthel());
            
            
            fila = hoja1.getRow(12);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getTotalAdutosMayoresControl());
            
            
            
            filas++;
            
        }
        
        // Seccion A1 Censo PSAM
        
        fila = hoja1.createRow(15);
        celda = fila.createCell(0);
        txt = "SECCION A.1: EXISTENCIA DE POBLACIÓN EN CONTROL EN PROGRAMA \"MÁS ADULTOS MAYORES AUTOVALENTES\"";
        celda.setCellValue(txt);
        
        
        // Columna derecha
        fila = hoja1.createRow(16);
        celda = fila.createCell(0);
        txt = "CONDICIÓN DE FUNCIONALIDAD";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(17);
        celda = fila.createCell(0);
        txt = "Autovalente sin Riesgo";
        
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(18);
        celda = fila.createCell(0);
        txt = "Autovalente con Riesgo";
        
        celda.setCellValue(txt);
        fila = hoja1.createRow(19);
        celda = fila.createCell(0);
        txt = "Riesgo de dependencia";
        
      
        celda.setCellValue(txt);
        fila = hoja1.createRow(20);
        celda = fila.createCell(0);
        txt = "SubTotal Efam";
        celda.setCellValue(txt);
        
        
        hoja1.autoSizeColumn(0);
        
        
        // Fila arriba
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(1);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(1);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(4);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(4);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(5);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(5);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(6);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(6);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(7);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(7);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(8);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(9);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(10);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(10);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(10);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(11);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(11);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(11);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(12);
        txt = "Pueblos";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(12);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(12);
        
        fila = hoja1.getRow(15);
        celda = fila.createCell(13);
        txt = "Originarios";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(13);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(13);
        
        int filasa=1;
        for (CensoSeccionA censoIt : censoA1) {
            
            fila = hoja1.getRow(17);
            celda = fila.createCell(filasa);
            celda.setCellValue(censoIt.getContadorAutovalenteSinRiesgo());
            
            fila = hoja1.getRow(18);
            celda = fila.createCell(filasa);
            celda.setCellValue(censoIt.getContadorAutovalenteConRiesgo());
            
            fila = hoja1.getRow(19);
            celda = fila.createCell(filasa);
            celda.setCellValue(censoIt.getContadorRiesgoDependencia());
            
            fila = hoja1.getRow(20);
            celda = fila.createCell(filasa);
            celda.setCellValue(censoIt.getSubTotalEfam());
            
            filasa++;
            
        }
        
        
        // Sección B Censo PSAM
        
        fila = hoja1.createRow(23);
        celda = fila.createCell(0);
        txt = "SECCION B: POBLACIÓN BAJO CONTROL POR ESTADO NUTRICIONAL";
        celda.setCellValue(txt);
        
        
        // Columna derecha
        fila = hoja1.createRow(24);
        celda = fila.createCell(0);
        txt = "ESTADO NUTRICIONAL";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(25);
        celda = fila.createCell(0);
        txt = "Bajo Peso";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(26);
        celda = fila.createCell(0);
        txt = "Normal";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(27);
        celda = fila.createCell(0);
        txt = "Sobre Peso";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(28);
        celda = fila.createCell(0);
        txt = "Obeso";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(29);
        celda = fila.createCell(0);
        txt = "Total";
        celda.setCellValue(txt);
        
        hoja1.autoSizeColumn(0);
        
        
        // Fila arriba
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(1);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(1);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(4);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(4);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(5);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(5);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(6);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(6);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(7);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(7);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(8);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(9);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(10);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(10);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(10);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(11);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(11);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(11);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(12);
        txt = "Pueblos";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(12);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(12);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(13);
        txt = "Originarios";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(13);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(13);
        
        int filas2=1;
        for (CensoSeccionB censoIt : censoB) {
            
            fila = hoja1.getRow(25);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getContadorBajoPeso());
            
            fila = hoja1.getRow(26);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getContadorNormal());
            
            fila = hoja1.getRow(27);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getContadorSobrepeso());
            
            fila = hoja1.getRow(28);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getContadorObeso());
            
            fila = hoja1.getRow(29);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getTotalSeccionB());
            
            filas2++;
            
        }
        
        
         // Sección C Censo PSAM
        
        fila = hoja1.createRow(32);
        celda = fila.createCell(0);
        txt = "SECCION C: ADULTOS MAYORES CON SOSPECHA DE MALTRATO";
        celda.setCellValue(txt);
        
        
        // Columna derecha
        fila = hoja1.createRow(33);
        celda = fila.createCell(0);
        txt = "CONCEPTO";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(34);
        celda = fila.createCell(0);
        txt = "Personas Con Sospecha de Maltrato";
        celda.setCellValue(txt);
        
        hoja1.autoSizeColumn(0);
        
        
        // Fila arriba
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(1);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(1);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(4);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(4);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(5);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(5);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(6);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(6);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(7);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(7);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(8);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(9);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(10);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(10);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(10);
        
        fila = hoja1.getRow(32);
        celda = fila.createCell(11);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(33);
        celda = fila.createCell(11);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(11);
        
        
        int filas3=1;
        for (CensoSeccionC censoIt : censoC) {
            
            fila = hoja1.getRow(34);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getTotalSeccionC());
            
      
            filas3++;
            
        }
        
        
         // Sección D Censo PSAM
       
        fila = hoja1.createRow(37);
        celda = fila.createCell(0);
        txt = "SECCION D: ADULTOS MAYORES  EN ACTIVIDAD FÍSICA";
        celda.setCellValue(txt);
        
        
        // Columna derecha
        fila = hoja1.createRow(38);
        celda = fila.createCell(0);
        txt = "CONCEPTO";
        celda.setCellValue(txt);
        
       
        
        fila = hoja1.createRow(39);
        celda = fila.createCell(0);
        txt = "Personas en Actividad Física";
        celda.setCellValue(txt);
        
        hoja1.autoSizeColumn(0);
        
        
        // Fila arriba
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(1);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(1);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(4);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(4);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(5);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(5);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(6);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(6);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(7);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(7);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(8);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(9);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(10);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(10);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(10);
        
        fila = hoja1.getRow(37);
        celda = fila.createCell(11);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(38);
        celda = fila.createCell(11);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(11);
        
        
        int filas4=1;
        for (CensoSeccionD censoIt : censoD) {
            
            fila = hoja1.getRow(39);
            celda = fila.createCell(filas4);
            celda.setCellValue(censoIt.getTotalSeccionD());
            
      
            filas4++;
            
        }
        
        // Sección E Censo PSAM
        
        fila = hoja1.createRow(42);
        celda = fila.createCell(0);
        txt = "SECCION E: POBLACIÓN DE ADULTOS MAYORES INSTITUCIONALIZADOS";
        celda.setCellValue(txt);
        
        
        // Columna derecha
        fila = hoja1.createRow(43);
        celda = fila.createCell(0);
        txt = "CONCEPTO";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(44);
        celda = fila.createCell(0);
        txt = "Adultos Mayores Institucionalizados";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(45);
        celda = fila.createCell(0);
        txt = "Adultos Mayores Dependencia Severa";
        celda.setCellValue(txt);
        
        hoja1.autoSizeColumn(0);
        
        
        // Fila arriba
        
        fila = hoja1.getRow(42);
        celda = fila.createCell(1);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(43);
        celda = fila.createCell(1);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        fila = hoja1.getRow(42);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(43);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(42);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(43);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
       
        
        int filas5=1;
        for (CensoSeccionE censoIt : censoE) {
            
            fila = hoja1.getRow(44);
            celda = fila.createCell(filas5);
            celda.setCellValue(censoIt.getTotal_institu());
            
            fila = hoja1.getRow(45);
            celda = fila.createCell(filas5);
            celda.setCellValue(censoIt.getTotal_severo());
            
      
            filas5++;
            
        }
        
        // Sección F Censo PSAM
        
        
        fila = hoja1.createRow(48);
        celda = fila.createCell(0);
        txt = "SECCION F: ADULTOS MAYORES CON RIESGO DE CAÍDAS";
        celda.setCellValue(txt);
        
        
        // Columna derecha
        fila = hoja1.createRow(49);
        celda = fila.createCell(0);
        txt = "TIPO DE RIESGO";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(50);
        celda = fila.createCell(0);
        txt = "Adultos Mayores con Riesgo de Caida Normal";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(51);
        celda = fila.createCell(0);
        txt = "Adultos Mayores con Riesgo de Caida Leve";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(52);
        celda = fila.createCell(0);
        txt = "Adultos Mayores con Riesgo de Caida Alto";
        celda.setCellValue(txt);
        
        hoja1.autoSizeColumn(0);
        
        
        // Fila arriba
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(1);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(1);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(4);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(4);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(5);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(5);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(6);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(6);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(7);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(7);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(8);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(9);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(10);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(10);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(10);
        
        fila = hoja1.getRow(48);
        celda = fila.createCell(11);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(49);
        celda = fila.createCell(11);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(11);
        
        int filas6=1;
        for (CensoSeccionF censoIt : censoF) {
            
            fila = hoja1.getRow(50);
            celda = fila.createCell(filas6);
            celda.setCellValue(censoIt.getRiesgo_normal());
            
            fila = hoja1.getRow(51);
            celda = fila.createCell(filas6);
            celda.setCellValue(censoIt.getRiesgo_leve());
            
            fila = hoja1.getRow(52);
            celda = fila.createCell(filas6);
            celda.setCellValue(censoIt.getRiesgo_alto());
            
      
            filas6++;
            
        }
        
        try {
           // FileOutputStream archivo = new FileOutputStream("resources/documents/censos/CensoPSAM.xlsx");
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) facesContext
                    .getExternalContext().getResponse();

            response.reset();
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition",
                    "attachment; filename=CensoPsam.xlsx");

            ServletOutputStream out = response.getOutputStream();
            libro.write(out);

            facesContext.responseComplete();

         //   libro.write(archivo);
           // archivo.close();
            
        } catch (Exception e) {
        
        }
        
        
    }
    public void preProcessPDFA(Object document) throws IOException, BadElementException, DocumentException {
      Document pdf = (Document) document;
      pdf.setPageSize(PageSize.LETTER.rotate());
      pdf.open();
      ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logoA = servletContext.getRealPath("") + File.separator + "resources" + File.separator  + "images" + File.separator + "logo-lawen-web.png";
        Image imagenA;
        imagenA = Image.getInstance(logoA);
        imagenA.setAlignment(Image.RIGHT);
        
        imagenA.scaleToFit(117, 40);
        pdf.add(imagenA);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        String url = request.getRequestURI().toString();
        Paragraph paragraph = new Paragraph();
        paragraph.setSpacingAfter(15);
        paragraph.setFirstLineIndent(36);
        String str2= "paciente";
	// atenciones
	String str3= "atencionENFVisitaDom";
	String str4= "atencionEnfFEMPA";
	String str5= "atencionGeneralAPSE";
	String str6= "atencionMedMorbilidad";
	String str7= "atencionNutriDietoterapia";
	String str8= "atencionNutriEmbarazada";

        if (url.toLowerCase().contains(str2.toLowerCase())){
            Chunk Titulo = new Chunk("Listado de Pacientes");
            Titulo.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            paragraph.add(Titulo);
        }
	else if (url.toLowerCase().contains(str3.toLowerCase())){
            Chunk Titulo = new Chunk("Atencion Enfermero(a) Visita Domiciliaria");
            Titulo.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            paragraph.add(Titulo);
        }
	else if (url.toLowerCase().contains(str4.toLowerCase())){
            Chunk Titulo = new Chunk("Atencion Enfermero(a) EMPA");
            Titulo.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            paragraph.add(Titulo);
        }
	else if (url.toLowerCase().contains(str5.toLowerCase())){
            Chunk Titulo = new Chunk("Atencion General Apse");
            Titulo.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            paragraph.add(Titulo);
        }
	else if (url.toLowerCase().contains(str6.toLowerCase())){
            Chunk Titulo = new Chunk("Atención Médico Morbilidad");
            Titulo.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            paragraph.add(Titulo);
        }
	else if (url.toLowerCase().contains(str7.toLowerCase())){
            Chunk Titulo = new Chunk("Atención Nutricionista Dietoterapia Ingreso/Control");
            Titulo.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            paragraph.add(Titulo);
        }
	else if (url.toLowerCase().contains(str8.toLowerCase())){
            Chunk Titulo = new Chunk("Atención Nutricionista Embarazada ");
            Titulo.setUnderline(0.1f, -2f); //0.1 thick, -2 y-location
            paragraph.add(Titulo);
        }
        
        paragraph.setAlignment(Element.ALIGN_LEFT);
        pdf.add(paragraph);
    }
    
    public void preProcessExcelPCV(){
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja1 = libro.createSheet("Censo Cardiovascular");
        
        List<CensoCCVSeccionA> censo = consCVV.getA_elementos();
        List<CensoCCVSeccionB> censoB = consCVV.getB_elementos();
        List<CensoCCVSeccionC> censoC = consCVV.getC_elementos();
        
        // Censo PCV Sección A
        // Columna derecha
        HSSFRow fila = hoja1.createRow(0);
        HSSFCell celda = fila.createCell(0);
        String txt = "REM-P4 POBLACIÓN EN CONTROL PROGRAMA DE SALUD CARDIOVASCULAR";
        celda.setCellValue(txt);
       
        
        HSSFCellStyle cellStyle = libro.createCellStyle();
        cellStyle = libro.createCellStyle();
        HSSFFont hSSFFont = libro.createFont();
        //hSSFFont.setFontName(HSSFFont.FONT_ARIAL);
        hSSFFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //hSSFFont.setColor(HSSFColor.GREEN.index);
        cellStyle.setFont(hSSFFont);
        celda.setCellStyle(cellStyle);
        CellUtil.setAlignment(celda, libro, CellStyle.ALIGN_CENTER);
        hoja1.addMergedRegion(new CellRangeAddress(0,0,0,15));
        
        fila = hoja1.createRow(1);
        celda = fila.createCell(0);
        txt = "SECCIÓN A: PROGRAMA DE SALUD CARDIOVASCULAR (PSCV)";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(2);
        celda = fila.createCell(0);
        txt = "Concepto";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(3);
        celda = fila.createCell(0);
        txt = "Número de personas en PSCV";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(2,2,0,1));
        hoja1.addMergedRegion(new CellRangeAddress(3,3,0,1));
        
        fila = hoja1.createRow(4);
        celda = fila.createCell(0);
        txt = "Clasificación del Riesgo Cardiovascular";
        celda.setCellValue(txt);
        CellUtil.setAlignment(celda, libro, CellStyle.ALIGN_CENTER);
        CellUtil.setAlignment(celda, libro, CellStyle.VERTICAL_CENTER);
        
        
        fila = hoja1.getRow(4);
        celda = fila.createCell(1);
        txt = "Bajo";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(5);
        celda = fila.createCell(0);
        txt = "Clasificación del Riesgo Cardiovascular";
        celda.setCellValue(txt);
        
        fila = hoja1.getRow(5);
        celda = fila.createCell(1);
        txt = "Moderado";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(6);
        celda = fila.createCell(0);
        txt = "Clasificación del Riesgo Cardiovascular";
        celda.setCellValue(txt);
        fila = hoja1.getRow(6);
        celda = fila.createCell(1);
        txt = "Alto";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(4,6,0,0));
        
        
        fila = hoja1.createRow(7);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Según Patología y Factores de Riesgo";
        celda.setCellValue(txt);
        fila = hoja1.getRow(7);
        celda = fila.createCell(1);
        txt = "Hipertensos";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(8);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Según Patología y Factores de Riesgo";
        celda.setCellValue(txt);
        fila = hoja1.getRow(8);
        celda = fila.createCell(1);
        txt = "Diabeticos";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(9);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Según Patología y Factores de Riesgo";
        celda.setCellValue(txt);
        fila = hoja1.getRow(9);
        celda = fila.createCell(1);
        txt = "Dislipidemicos";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(10);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Según Patología y Factores de Riesgo";
        celda.setCellValue(txt);
        fila = hoja1.getRow(10);
        celda = fila.createCell(1);
        txt = "Tabaquismo ≥ a 55 años";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(11);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Según Patología y Factores de Riesgo";
        celda.setCellValue(txt);
        fila = hoja1.getRow(11);
        celda = fila.createCell(1);
        txt = "Antecedentes de Infarto Agudo al Miocardio";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(12);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Según Patología y Factores de Riesgo";
        celda.setCellValue(txt);
        fila = hoja1.getRow(12);
        celda = fila.createCell(1);
        txt = "Antecedentes de Enf. Cerebro Vascular";
        celda.setCellValue(txt);
        
        hoja1.addMergedRegion(new CellRangeAddress(7,12,0,0));
        
        fila = hoja1.createRow(13);
        celda = fila.createCell(0);
        txt = "Detección y prevensión de EnF. Crónica Renal (ERC)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(13);
        celda = fila.createCell(1);
        txt = "Sin Enfermedad Renal (S/ERC)";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(14);
        celda = fila.createCell(0);
        txt = "Detección y prevensión de EnF. Crónica Renal (ERC)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(14);
        celda = fila.createCell(1);
        txt = "Etapa G1 y Etapa G2";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(15);
        celda = fila.createCell(0);
        txt = "Detección y prevensión de EnF. Crónica Renal (ERC)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(15);
        celda = fila.createCell(1);
        txt = "Etapa G3a";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(16);
        celda = fila.createCell(0);
        txt = "Detección y prevensión de EnF. Crónica Renal (ERC)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(16);
        celda = fila.createCell(1);
        txt = "Etapa G3b";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(17);
        celda = fila.createCell(0);
        txt = "Detección y prevensión de EnF. Crónica Renal (ERC)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(17);
        celda = fila.createCell(1);
        txt = "Etapa G4";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(18);
        celda = fila.createCell(0);
        txt = "Detección y prevensión de EnF. Crónica Renal (ERC)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(18);
        celda = fila.createCell(1);
        txt = "Etapa G5";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(19);
        celda = fila.createCell(0);
        txt = "Detección y prevensión de EnF. Crónica Renal (ERC)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(19);
        celda = fila.createCell(1);
        txt = "Total";
        celda.setCellValue(txt);
        
        hoja1.addMergedRegion(new CellRangeAddress(13,19,0,0));
        
        hoja1.autoSizeColumn(0);
        hoja1.autoSizeColumn(1);
        
        
        // Fila arriba
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(2);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(3);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(4);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(4);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(5);
        txt = "15 a 19";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(5);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(6);
        txt = "15 a 19";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(6);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(7);
        txt = "20 a 24";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(7);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(8);
        txt = "20 a 24";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(8);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(9);
        txt = "25 a 29";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(9);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(10);
        txt = "25 a 29";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(10);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(10);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(11);
        txt = "30 a 34";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(11);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(11);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(12);
        txt = "30 a 34";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(12);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(12);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(13);
        txt = "35 a 39";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(13);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(13);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(14);
        txt = "35 a 39";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(14);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(14);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(15);
        txt = "40 a 44";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(15);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(15);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(16);
        txt = "40 a 44";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(16);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(16);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(17);
        txt = "45 a 49";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(17);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(17);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(18);
        txt = "45 a 49";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(18);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(18);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(19);
        txt = "50 a 54";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(19);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(19);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(20);
        txt = "50 a 54";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(20);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(20);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(21);
        txt = "55 a 59";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(21);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(21);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(22);
        txt = "55 a 59";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(22);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(22);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(23);
        txt = "60 a 64";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(23);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(23);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(24);
        txt = "60 a 64";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(24);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(24);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(25);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(25);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(25);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(26);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(26);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(26);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(27);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(27);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(27);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(28);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(28);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(28);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(29);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(29);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(29);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(30);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(30);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(30);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(31);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(31);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(31);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(32);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(32);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(32);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(33);
        txt = "Pueblos";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(33);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(33);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(34);
        txt = "Originarios";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(34);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(34);
        
        fila = hoja1.getRow(1);
        celda = fila.createCell(35);
        txt = "Pacientes";
        celda.setCellValue(txt);
        fila = hoja1.getRow(2);
        celda = fila.createCell(35);
        txt = "Diabeticos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(35);
        
        int filas=2;
        for (CensoCCVSeccionA censoIt : censo) {
            
            fila = hoja1.getRow(3);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPacientestotal());
            
            
            fila = hoja1.getRow(4);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getClasificacionRiesgoCCVBajo());
            
            fila = hoja1.getRow(5);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getClasificacionRiesgoCCVModerado());
            
            fila = hoja1.getRow(6);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getClasificacionRiesgoCCVAlto());
            
            fila = hoja1.getRow(7);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPBCsegunPyFRHipertensos());
            
            fila = hoja1.getRow(8);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPBCsegunPyFRDiabeticos());
            
            
            fila = hoja1.getRow(9);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPBCsegunPyFRDislipidemicos());
            
            fila = hoja1.getRow(10);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPBCsegunPyFRTabaquismo());
            
            
            fila = hoja1.getRow(11);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPBCsegunPyFRAntInfarto());
            
            fila = hoja1.getRow(12);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPBCsegunPyFRAntEnfCerebroVascular());
            
            
            fila = hoja1.getRow(13);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getSinERC());
            
            fila = hoja1.getRow(14);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getEtapa1_2());
            
            fila = hoja1.getRow(15);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getEtapa3a());
            
            fila = hoja1.getRow(16);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getEtapa3b());
            
            fila = hoja1.getRow(17);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getEtapa4());
            
            fila = hoja1.getRow(18);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getEtapa5());
            
            fila = hoja1.getRow(19);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getTotal());
            
            filas++;
            
        }
        
        // SECCIÓN B
        
        fila = hoja1.createRow(23);
        celda = fila.createCell(0);
        txt = "SECCIÓN B: METAS DE CONPENSACIÓN";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(24);
        celda = fila.createCell(0);
        txt = "Concepto";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(25);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Por Hipertención";
        celda.setCellValue(txt);
        fila = hoja1.getRow(25);
        celda = fila.createCell(1);
        txt = "PA < 149/90 mmHg";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(26);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Por Diabetes Mellitus";
        celda.setCellValue(txt);
        fila = hoja1.getRow(26);
        celda = fila.createCell(1);
        txt = "HbA1C<7%";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(27);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control Por Diabetes Mellitus";
        celda.setCellValue(txt);
        fila = hoja1.getRow(27);
        celda = fila.createCell(1);
        txt = "HbA1C<7% - PA < 140/90mmHg y Colesterol LDL < 100 mg/dl";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(26,27,0,0));
        
        
        fila = hoja1.createRow(28);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control En Riesgo CV. Alto";
        celda.setCellValue(txt);
        fila = hoja1.getRow(28);
        celda = fila.createCell(1);
        txt = "Colesterol LDL < 100 mg/dL";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(29);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control con antecedentes Enfermedad Cardiovascular (ECV)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(29);
        celda = fila.createCell(1);
        txt = "En tratamiento con Acido Acetilsalicílico ";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(30);
        celda = fila.createCell(0);
        txt = "Personas Bajo Control con antecedentes Enfermedad Cardiovascular (ECV)";
        celda.setCellValue(txt);
        fila = hoja1.getRow(30);
        celda = fila.createCell(1);
        txt = "En tratamiento con Estatina";
        celda.setCellValue(txt);
        
        hoja1.addMergedRegion(new CellRangeAddress(29,30,0,0));
        
        
        hoja1.autoSizeColumn(0);
        hoja1.autoSizeColumn(1);
        
        
        // Fila arriba
       
        fila = hoja1.getRow(23);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(2);
        txt = "Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(3);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(3);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(4);
        txt = "Total";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(4);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(5);
        txt = "15 a 19";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(5);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(6);
        txt = "15 a 19";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(6);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(7);
        txt = "20 a 24";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(7);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(8);
        txt = "20 a 24";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(8);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(9);
        txt = "25 a 29";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(9);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(10);
        txt = "25 a 29";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(10);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(10);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(11);
        txt = "30 a 34";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(11);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(11);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(12);
        txt = "30 a 34";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(12);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(12);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(13);
        txt = "35 a 39";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(13);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(13);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(14);
        txt = "35 a 39";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(14);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(14);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(15);
        txt = "40 a 44";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(15);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(15);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(16);
        txt = "40 a 44";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(16);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(16);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(17);
        txt = "45 a 49";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(17);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(17);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(18);
        txt = "45 a 49";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(18);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(18);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(19);
        txt = "50 a 54";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(19);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(19);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(20);
        txt = "50 a 54";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(20);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(20);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(21);
        txt = "55 a 59";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(21);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(21);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(22);
        txt = "55 a 59";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(22);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(22);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(23);
        txt = "60 a 64";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(23);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(23);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(24);
        txt = "60 a 64";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(24);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(24);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(25);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(25);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(25);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(26);
        txt = "65 a 69";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(26);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(26);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(27);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(27);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(27);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(28);
        txt = "70 a 74";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(28);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(28);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(29);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(29);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(29);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(30);
        txt = "75 a 79";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(30);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(30);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(31);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(31);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(31);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(32);
        txt = "80 a más";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(32);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(32);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(33);
        txt = "Pueblos";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(33);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(33);
        
        fila = hoja1.getRow(23);
        celda = fila.createCell(34);
        txt = "Originarios";
        celda.setCellValue(txt);
        fila = hoja1.getRow(24);
        celda = fila.createCell(34);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(34);
        
   
        
        int filas2=2;
        for (CensoCCVSeccionB censoIt : censoB) {
            
            fila = hoja1.getRow(25);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPBCHipertensionPAMen140_90());
            
            fila = hoja1.getRow(26);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPBCDiabetesHbA1CMen7());
            
            fila = hoja1.getRow(27);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPBCDiabetesHbA1CMen7_PAMen140_90_ColesterolLDLMen100());
            
            fila = hoja1.getRow(28);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPBCenRiesgoCCVNodiabeticas_Alto_MuyAlto_ColesterolLDLMen100());
            
            fila = hoja1.getRow(29);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPBCconAntecedentesCCV_TratramientoAcidoAcetil());
            
            fila = hoja1.getRow(30);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPBCconAntecedentesCCV_TratramientoEstanina());
            
            filas2++;
            
        }
        
       
        
         // SECCIÓN C
        
        fila = hoja1.createRow(33);
        celda = fila.createCell(0);
        txt = "SECCIÓN C: VARIABLES DE SEGUIMIENTO DEL PSCV AL CORTE";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(34);
        celda = fila.createCell(0);
        txt = "Variables";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(35);
        celda = fila.createCell(0);
        txt = "Personas Diabéticas En PSCV";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(34,34,0,1));
        hoja1.addMergedRegion(new CellRangeAddress(35,35,0,1));
        
        fila = hoja1.createRow(36);
        celda = fila.createCell(0);
        txt = "Con Razon Albúmina Creatinina (RAC), Vigente";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(36,36,0,1));
        
        
        fila = hoja1.createRow(37);
        celda = fila.createCell(0);
        txt = "Con Velocidad de Filtración Glomerular (VFG), Vigente";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(37,37,0,1));
        
        fila = hoja1.createRow(38);
        celda = fila.createCell(0);
        txt = "Con Fondo de Ojo, Vigente";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(38,38,0,1));
        
        fila = hoja1.createRow(39);
        celda = fila.createCell(0);
        txt = "En tratamiento con Insulina";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(39,39,0,1));
        
        
        fila = hoja1.createRow(40);
        celda = fila.createCell(0);
        txt = "Con HbA1C>= 9 %";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(40,40,0,1));
        
        fila = hoja1.createRow(41);
        celda = fila.createCell(0);
        txt = "En Tratamiento Con IECA O ARA II";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(41,41,0,1));
        
        fila = hoja1.createRow(42);
        celda = fila.createCell(0);
        txt = "Con un Exámen de Colesterol LDL Vigente";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(42,42,0,1));
        
        
        
        fila = hoja1.createRow(43);
        celda = fila.createCell(0);
        txt = "Con Evaluación Vigente del PIE \n Según Pauta de Estimación  \n del Riesgo de Ulceración \n en Personas con Diabetes";
        celda.setCellValue(txt);
        fila = hoja1.getRow(43);
        celda = fila.createCell(1);
        txt = "Riesgo bajo";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(44);
        celda = fila.createCell(0);
        txt = "Con Evaluación Vigente del PIE \n Según Pauta de Estimación  \n del Riesgo de Ulceración \n en Personas con Diabetes";
        celda.setCellValue(txt);
        fila = hoja1.getRow(44);
        celda = fila.createCell(1);
        txt = "Riesgo moderado";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(45);
        celda = fila.createCell(0);
        txt = "Con Evaluación Vigente del PIE \n Según Pauta de Estimación  \n del Riesgo de Ulceración \n en Personas con Diabetes";
        celda.setCellValue(txt);
        fila = hoja1.getRow(45);
        celda = fila.createCell(1);
        txt = "Riesgo alto";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(46);
        celda = fila.createCell(0);
        txt = "Con Evaluación Vigente del PIE \n Según Pauta de Estimación  \n del Riesgo de Ulceración \n en Personas con Diabetes";
        celda.setCellValue(txt);
        fila = hoja1.getRow(46);
        celda = fila.createCell(1);
        txt = "Riesgo maximo";
        celda.setCellValue(txt);
      
        hoja1.addMergedRegion(new CellRangeAddress(43,46,0,0));
        
        hoja1.autoSizeColumn(0);
        hoja1.autoSizeColumn(1);
   
        
        fila = hoja1.createRow(47);
        celda = fila.createCell(0);
        txt = "Con Úlceras Activas de PIE Tratadas con Curación";
        celda.setCellValue(txt);
        fila = hoja1.getRow(47);
        celda = fila.createCell(1);
        txt = "Curación Convencional";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(48);
        celda = fila.createCell(0);
        txt = "Con Úlceras Activas de PIE Tratadas con Curación";
        celda.setCellValue(txt);
        fila = hoja1.getRow(48);
        celda = fila.createCell(1);
        txt = "Curación Avanzada";
        celda.setCellValue(txt);
        
        hoja1.addMergedRegion(new CellRangeAddress(47,48,0,0));
        
        hoja1.autoSizeColumn(0);
        hoja1.autoSizeColumn(1);
   
        
    
        
        fila = hoja1.createRow(49);
        celda = fila.createCell(0);
        txt = "Pacientes Diabéticos con Evaluación, en los Ultimos 12 Meses, \n de Calidad Registrada en QUALIDIAB u Otro Sistema Informático";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(49,50,0,1));
        hoja1.autoSizeColumn(0);
        
        
        fila = hoja1.createRow(51);
        celda = fila.createCell(0);
        txt = "Personas Hipertensas con Razón Albúmina Creatinina (RAC), Vigente";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(51,51,0,1));
        hoja1.autoSizeColumn(0);
        
        
        
        // Fila arriba
      
        fila = hoja1.getRow(34);
        celda = fila.createCell(2);
        txt = "Total";
        celda.setCellValue(txt);
        hoja1.addMergedRegion(new CellRangeAddress(34,35,2,2));
        hoja1.autoSizeColumn(2);
        
        
        fila = hoja1.getRow(34);
        celda = fila.createCell(3);
        txt = "Edad";
        celda.setCellValue(txt);
        fila = hoja1.getRow(35);
        celda = fila.createCell(3);
        txt = "15 a 64";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        
        fila = hoja1.getRow(34);
        celda = fila.createCell(4);
        txt = "Edad";
        celda.setCellValue(txt);
        fila = hoja1.getRow(35);
        celda = fila.createCell(4);
        txt = "65 y más";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        
        fila = hoja1.getRow(34);
        celda = fila.createCell(5);
        txt = "Sexo";
        celda.setCellValue(txt);
        fila = hoja1.getRow(35);
        celda = fila.createCell(5);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(34);
        celda = fila.createCell(6);
        txt = "Sexo";
        celda.setCellValue(txt);
        fila = hoja1.getRow(35);
        celda = fila.createCell(6);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        int filas3=2;
        for (CensoCCVSeccionC censoIt : censoC) {
            
          
            fila = hoja1.getRow(36);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPDI12MESES_RAC());
            
            fila = hoja1.getRow(37);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPDI12MESES_VFG());
            
            fila = hoja1.getRow(38);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPDI12MESES_FondoDeOjo());
            
            fila = hoja1.getRow(39);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getTratamientoInsulina());
            
            fila = hoja1.getRow(40);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getHbA1C9());
            
            fila = hoja1.getRow(41);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getTratamientoConIECAoARRAII());
            
            fila = hoja1.getRow(42);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getExamenColesterolLDLVigente());
            
            fila = hoja1.getRow(43);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getUlceracion_RiesgoBajo());
            
            fila = hoja1.getRow(44);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getUlceracion_RiesgoModerado());
            
            fila = hoja1.getRow(45);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getUlceracion_RiesgoAlto());
            
            fila = hoja1.getRow(46);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getUlceracion_RiesgoMaximo());
            
            fila = hoja1.getRow(47);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getUlcerasActivas_CuracionCo());
            
            fila = hoja1.getRow(48);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getUlcerasActivas_CuracionAvan());
            
            fila = hoja1.getRow(49);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPDE12Meses_Qualdiab_Otros());
            
            fila = hoja1.getRow(51);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getRAC());
            
            
            filas3++;
            
        }
        
        
        
        try {
           // FileOutputStream archivo = new FileOutputStream("resources/documents/censos/CensoPSAM.xlsx");
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) facesContext
                    .getExternalContext().getResponse();

            response.reset();
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition",
                    "attachment; filename=CensoPCV.xlsx");

            ServletOutputStream out = response.getOutputStream();
            libro.write(out);

            facesContext.responseComplete();

         //   libro.write(archivo);
           // archivo.close();
            
        } catch (Exception e) {
        
        }
        
    }
    
    public void preProcessExcelNoREM (){
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja1 = libro.createSheet("Censo Cardiovascular No REM");
        
        List<CensoCCVnoREM> censo15a19 = consCVVnoREM.getPacientes15a19();
        List<CensoCCVnoREM> censo20a64 = consCVVnoREM.getPacientes20a64();
        List<CensoCCVnoREM> censo65yMas = consCVVnoREM.getPacientes65ymas();
        
       
        // Censo PCV no REM Sección 15 a 19
        // Columna derecha
        HSSFRow fila = hoja1.createRow(0);
        HSSFCell celda = fila.createCell(0);
        String txt = "NO REM - POBLACIÓN EN CONTROL PROGRAMA DE SALUD CARDIOVASCULAR";
        celda.setCellValue(txt);
       
        
        HSSFCellStyle cellStyle = libro.createCellStyle();
        cellStyle = libro.createCellStyle();
        HSSFFont hSSFFont = libro.createFont();
        //hSSFFont.setFontName(HSSFFont.FONT_ARIAL);
        hSSFFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        //hSSFFont.setColor(HSSFColor.GREEN.index);
        cellStyle.setFont(hSSFFont);
        celda.setCellStyle(cellStyle);
        CellUtil.setAlignment(celda, libro, CellStyle.ALIGN_CENTER);
        hoja1.addMergedRegion(new CellRangeAddress(0,0,0,15));
        
        
        fila = hoja1.createRow(1);
        celda = fila.createCell(0);
        txt = "SECCIÓN 15 A 19 AÑOS CENSO NO REM PCCV";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(4);
        celda = fila.createCell(0);
        txt = "PBC Censo";
        celda.setCellValue(txt);
        fila = hoja1.createRow(5);
        celda = fila.createCell(0);
        txt = "Fallecidos";
        celda.setCellValue(txt);
        fila = hoja1.createRow(6);
        celda = fila.createCell(0);
        txt = "Perfíl lipídico";
        celda.setCellValue(txt);
        fila = hoja1.createRow(7);
        celda = fila.createCell(0);
        txt = "Fondo de Ojo";
        celda.setCellValue(txt);
        fila = hoja1.createRow(8);
        celda = fila.createCell(0);
        txt = "Atención podológica";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(9);
        celda = fila.createCell(0);
        txt = "HbA1C 4 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(10);
        celda = fila.createCell(0);
        txt = "HbA1C 3 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(11);
        celda = fila.createCell(0);
        txt = "HbA1C 2 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(12);
        celda = fila.createCell(0);
        txt = "HbA1C 1 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(13);
        celda = fila.createCell(0);
        txt = "Creatinina";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(14);
        celda = fila.createCell(0);
        txt = "Potasio plasmático";
        celda.setCellValue(txt);

        
        fila = hoja1.createRow(15);
        celda = fila.createCell(0);
        txt = "Microalbuminuria";
        celda.setCellValue(txt);

        fila = hoja1.createRow(16);
        celda = fila.createCell(0);
        txt = "Electrocardiograma";
        celda.setCellValue(txt);

        fila = hoja1.createRow(17);
        celda = fila.createCell(0);
        txt = "Complicación(Prevalencia)";
        celda.setCellValue(txt);

        fila = hoja1.createRow(18);
        celda = fila.createCell(0);
        txt = "Retinopatía diabética";
        celda.setCellValue(txt);

        fila = hoja1.createRow(19);
        celda = fila.createCell(0);
        txt = "Infarto AG. del miocardio";
        celda.setCellValue(txt);

        fila = hoja1.createRow(20);
        celda = fila.createCell(0);
        txt = "Accidente vascular encefálico";
        celda.setCellValue(txt);

        fila = hoja1.createRow(21);
        celda = fila.createCell(0);
        txt = "Ceguera post retinopatía DBT";
        celda.setCellValue(txt);

        fila = hoja1.createRow(22);
        celda = fila.createCell(0);
        txt = "Hipertrofia ventricular izquierda";
        celda.setCellValue(txt);

        fila = hoja1.createRow(23);
        celda = fila.createCell(0);
        txt = "Nefropatía incipiente";
        celda.setCellValue(txt);

        fila = hoja1.createRow(24);
        celda = fila.createCell(0);
        txt = "Insuficiencia renal crónica terminal";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(25);
        celda = fila.createCell(0);
        txt = "Pie diabético(con evaluación)";
        celda.setCellValue(txt);

        fila = hoja1.createRow(26);
        celda = fila.createCell(0);
        txt = "Pie diabético con ulcera";
        celda.setCellValue(txt);

        fila = hoja1.createRow(27);
        celda = fila.createCell(0);
        txt = "Pie diabético(manejo avanzado de herida)";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(28);
        celda = fila.createCell(0);
        txt = "Amputación diabética";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(29);
        celda = fila.createCell(0);
        txt = "Pre diabeticos";
        celda.setCellValue(txt);


        hoja1.autoSizeColumn(0);
        hoja1.autoSizeColumn(1);
        
        // Fila arriba
        fila = hoja1.createRow(2);
        celda = fila.createCell(1);
        txt = "DIABETICOS";
        celda.setCellValue(txt);
        fila = hoja1.createRow(3);
        celda = fila.createCell(1);
        txt = "Total Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        
        fila = hoja1.getRow(2);
        celda = fila.createCell(2);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(3);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(2);
        celda = fila.createCell(3);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(3);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        
        fila = hoja1.getRow(2);
        celda = fila.createCell(4);
        txt = "HIPERTENSOS";
        celda.setCellValue(txt);
        fila = hoja1.getRow(3);
        celda = fila.createCell(4);
        txt = "Total ambos sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(2);
        celda = fila.createCell(5);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(3);
        celda = fila.createCell(5);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(2);
        celda = fila.createCell(6);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(3);
        celda = fila.createCell(6);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(2);
        celda = fila.createCell(7);
        txt = "DISLIPIDEMICOS";
        celda.setCellValue(txt);
        fila = hoja1.getRow(3);
        celda = fila.createCell(7);
        txt = "Total ambos sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(2);
        celda = fila.createCell(8);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(3);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(2);
        celda = fila.createCell(9);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(3);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        int filas=1;
        for (CensoCCVnoREM censoIt : censo15a19) {
            
            fila = hoja1.getRow(4);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPbc());
            
            
            fila = hoja1.getRow(5);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getFallecidos());
            
            fila = hoja1.getRow(6);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPerfilLipidico());
            
            fila = hoja1.getRow(7);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getFondoOjo());
            
            fila = hoja1.getRow(8);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getAtencionPodologica());
            
            fila = hoja1.getRow(9);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getHba1c4());
            
            
            fila = hoja1.getRow(10);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getHba1c3());
            
            fila = hoja1.getRow(11);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getHba1c2());
            
            
            fila = hoja1.getRow(12);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getHba1c1());
            
            
            fila = hoja1.getRow(13);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getCreatinina());
            
            fila = hoja1.getRow(14);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPotasioPlasmatico());
            
            
            fila = hoja1.getRow(15);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getMicroalbuminuria());
            
            fila = hoja1.getRow(16);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getEcg());
            
            fila = hoja1.getRow(17);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getComplicacion());
            
            fila = hoja1.getRow(18);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getRetinopatiaDiabetica());
            
            fila = hoja1.getRow(19);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getInfarto());
            
            fila = hoja1.getRow(20);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getAccidenteVascular());
            
            
            fila = hoja1.getRow(20);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getAccidenteVascular());
            
            
            fila = hoja1.getRow(21);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getCegueraPost());
            
            fila = hoja1.getRow(22);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getHipertrofia());
            
            fila = hoja1.getRow(23);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getNefropatia());
            
            fila = hoja1.getRow(24);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getInsuficienciaRenal());
            
            fila = hoja1.getRow(25);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPieDiabeticoEvaluacion());
            
            fila = hoja1.getRow(26);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPieDiabeticoUlcera());
            
            fila = hoja1.getRow(27);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPieDiabeticoHerida());
            
            fila = hoja1.getRow(28);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getAmputacionDiabetica());
            
            fila = hoja1.getRow(29);
            celda = fila.createCell(filas);
            celda.setCellValue(censoIt.getPreDiabeticos());
            
            filas++;
            
        }
       
        // SECCION 20 A 64 AÑOS
        
        
        fila = hoja1.createRow(32);
        celda = fila.createCell(0);
        txt = "SECCIÓN 20 A 64 AÑOS CENSO NO REM PCCV";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(35);
        celda = fila.createCell(0);
        txt = "PBC Censo";
        celda.setCellValue(txt);
        fila = hoja1.createRow(36);
        celda = fila.createCell(0);
        txt = "Fallecidos";
        celda.setCellValue(txt);
        fila = hoja1.createRow(37);
        celda = fila.createCell(0);
        txt = "Perfíl lipídico";
        celda.setCellValue(txt);
        fila = hoja1.createRow(38);
        celda = fila.createCell(0);
        txt = "Fondo de Ojo";
        celda.setCellValue(txt);
        fila = hoja1.createRow(39);
        celda = fila.createCell(0);
        txt = "Atención podológica";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(40);
        celda = fila.createCell(0);
        txt = "HbA1C 4 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(41);
        celda = fila.createCell(0);
        txt = "HbA1C 3 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(42);
        celda = fila.createCell(0);
        txt = "HbA1C 2 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(43);
        celda = fila.createCell(0);
        txt = "HbA1C 1 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(44);
        celda = fila.createCell(0);
        txt = "Creatinina";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(45);
        celda = fila.createCell(0);
        txt = "Potasio plasmático";
        celda.setCellValue(txt);

        
        fila = hoja1.createRow(46);
        celda = fila.createCell(0);
        txt = "Microalbuminuria";
        celda.setCellValue(txt);

        fila = hoja1.createRow(47);
        celda = fila.createCell(0);
        txt = "Electrocardiograma";
        celda.setCellValue(txt);

        fila = hoja1.createRow(48);
        celda = fila.createCell(0);
        txt = "Complicación(Prevalencia)";
        celda.setCellValue(txt);

        fila = hoja1.createRow(49);
        celda = fila.createCell(0);
        txt = "Retinopatía diabética";
        celda.setCellValue(txt);

        fila = hoja1.createRow(50);
        celda = fila.createCell(0);
        txt = "Infarto AG. del miocardio";
        celda.setCellValue(txt);

        fila = hoja1.createRow(51);
        celda = fila.createCell(0);
        txt = "Accidente vascular encefálico";
        celda.setCellValue(txt);

        fila = hoja1.createRow(52);
        celda = fila.createCell(0);
        txt = "Ceguera post retinopatía DBT";
        celda.setCellValue(txt);

        fila = hoja1.createRow(53);
        celda = fila.createCell(0);
        txt = "Hipertrofia ventricular izquierda";
        celda.setCellValue(txt);

        fila = hoja1.createRow(54);
        celda = fila.createCell(0);
        txt = "Nefropatía incipiente";
        celda.setCellValue(txt);

        fila = hoja1.createRow(55);
        celda = fila.createCell(0);
        txt = "Insuficiencia renal crónica terminal";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(56);
        celda = fila.createCell(0);
        txt = "Pie diabético(con evaluación)";
        celda.setCellValue(txt);

        fila = hoja1.createRow(57);
        celda = fila.createCell(0);
        txt = "Pie diabético con ulcera";
        celda.setCellValue(txt);

        fila = hoja1.createRow(58);
        celda = fila.createCell(0);
        txt = "Pie diabético(manejo avanzado de herida)";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(59);
        celda = fila.createCell(0);
        txt = "Amputación diabética";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(60);
        celda = fila.createCell(0);
        txt = "Pre diabeticos";
        celda.setCellValue(txt);


        hoja1.autoSizeColumn(0);
        hoja1.autoSizeColumn(1);
        
        // Fila arriba
        fila = hoja1.createRow(33);
        celda = fila.createCell(1);
        txt = "DIABETICOS";
        celda.setCellValue(txt);
        fila = hoja1.createRow(34);
        celda = fila.createCell(1);
        txt = "Total Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        
        fila = hoja1.getRow(33);
        celda = fila.createCell(2);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(34);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(33);
        celda = fila.createCell(3);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(34);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        
        fila = hoja1.getRow(33);
        celda = fila.createCell(4);
        txt = "HIPERTENSOS";
        celda.setCellValue(txt);
        fila = hoja1.getRow(34);
        celda = fila.createCell(4);
        txt = "Total ambos sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(33);
        celda = fila.createCell(5);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(34);
        celda = fila.createCell(5);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(33);
        celda = fila.createCell(6);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(34);
        celda = fila.createCell(6);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(33);
        celda = fila.createCell(7);
        txt = "DISLIPIDEMICOS";
        celda.setCellValue(txt);
        fila = hoja1.getRow(34);
        celda = fila.createCell(7);
        txt = "Total ambos sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(33);
        celda = fila.createCell(8);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(34);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(33);
        celda = fila.createCell(9);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(34);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        int filas2=1;
        for (CensoCCVnoREM censoIt : censo20a64) {
            
            fila = hoja1.getRow(35);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPbc());
            
            
            fila = hoja1.getRow(36);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getFallecidos());
            
            fila = hoja1.getRow(37);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPerfilLipidico());
            
            fila = hoja1.getRow(38);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getFondoOjo());
            
            fila = hoja1.getRow(39);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getAtencionPodologica());
            
            fila = hoja1.getRow(40);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getHba1c4());
            
            
            fila = hoja1.getRow(41);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getHba1c3());
            
            fila = hoja1.getRow(42);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getHba1c2());
            
            
            fila = hoja1.getRow(43);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getHba1c1());
            
            
            fila = hoja1.getRow(44);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getCreatinina());
            
            fila = hoja1.getRow(45);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPotasioPlasmatico());
            
            
            fila = hoja1.getRow(46);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getMicroalbuminuria());
            
            fila = hoja1.getRow(47);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getEcg());
            
            fila = hoja1.getRow(48);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getComplicacion());
            
            fila = hoja1.getRow(49);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getRetinopatiaDiabetica());
            
            fila = hoja1.getRow(50);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getInfarto());
            
            fila = hoja1.getRow(51);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getAccidenteVascular());
            
            fila = hoja1.getRow(52);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getCegueraPost());
            
            fila = hoja1.getRow(53);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getHipertrofia());
            
            fila = hoja1.getRow(54);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getNefropatia());
            
            fila = hoja1.getRow(55);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getInsuficienciaRenal());
            
            fila = hoja1.getRow(56);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPieDiabeticoEvaluacion());
            
            fila = hoja1.getRow(57);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPieDiabeticoUlcera());
            
            fila = hoja1.getRow(58);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPieDiabeticoHerida());
            
            fila = hoja1.getRow(59);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getAmputacionDiabetica());
            
            fila = hoja1.getRow(60);
            celda = fila.createCell(filas2);
            celda.setCellValue(censoIt.getPreDiabeticos());
            
            filas2++;
            
        }
        
        
        // SECCION 65 y MÁS
        
        
        fila = hoja1.createRow(63);
        celda = fila.createCell(0);
        txt = "SECCIÓN 65 AÑOS Y MÁS CENSO NO REM PCCV";
        celda.setCellValue(txt);
        
        
        fila = hoja1.createRow(66);
        celda = fila.createCell(0);
        txt = "PBC Censo";
        celda.setCellValue(txt);
        fila = hoja1.createRow(67);
        celda = fila.createCell(0);
        txt = "Fallecidos";
        celda.setCellValue(txt);
        fila = hoja1.createRow(68);
        celda = fila.createCell(0);
        txt = "Perfíl lipídico";
        celda.setCellValue(txt);
        fila = hoja1.createRow(69);
        celda = fila.createCell(0);
        txt = "Fondo de Ojo";
        celda.setCellValue(txt);
        fila = hoja1.createRow(70);
        celda = fila.createCell(0);
        txt = "Atención podológica";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(71);
        celda = fila.createCell(0);
        txt = "HbA1C 4 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(72);
        celda = fila.createCell(0);
        txt = "HbA1C 3 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(73);
        celda = fila.createCell(0);
        txt = "HbA1C 2 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(74);
        celda = fila.createCell(0);
        txt = "HbA1C 1 en año";
        celda.setCellValue(txt);

        fila = hoja1.createRow(75);
        celda = fila.createCell(0);
        txt = "Creatinina";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(76);
        celda = fila.createCell(0);
        txt = "Potasio plasmático";
        celda.setCellValue(txt);

        
        fila = hoja1.createRow(77);
        celda = fila.createCell(0);
        txt = "Microalbuminuria";
        celda.setCellValue(txt);

        fila = hoja1.createRow(78);
        celda = fila.createCell(0);
        txt = "Electrocardiograma";
        celda.setCellValue(txt);

        fila = hoja1.createRow(79);
        celda = fila.createCell(0);
        txt = "Complicación(Prevalencia)";
        celda.setCellValue(txt);

        fila = hoja1.createRow(80);
        celda = fila.createCell(0);
        txt = "Retinopatía diabética";
        celda.setCellValue(txt);

        fila = hoja1.createRow(81);
        celda = fila.createCell(0);
        txt = "Infarto AG. del miocardio";
        celda.setCellValue(txt);

        fila = hoja1.createRow(82);
        celda = fila.createCell(0);
        txt = "Accidente vascular encefálico";
        celda.setCellValue(txt);

        fila = hoja1.createRow(83);
        celda = fila.createCell(0);
        txt = "Ceguera post retinopatía DBT";
        celda.setCellValue(txt);

        fila = hoja1.createRow(84);
        celda = fila.createCell(0);
        txt = "Hipertrofia ventricular izquierda";
        celda.setCellValue(txt);

        fila = hoja1.createRow(85);
        celda = fila.createCell(0);
        txt = "Nefropatía incipiente";
        celda.setCellValue(txt);

        fila = hoja1.createRow(86);
        celda = fila.createCell(0);
        txt = "Insuficiencia renal crónica terminal";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(87);
        celda = fila.createCell(0);
        txt = "Pie diabético(con evaluación)";
        celda.setCellValue(txt);

        fila = hoja1.createRow(88);
        celda = fila.createCell(0);
        txt = "Pie diabético con ulcera";
        celda.setCellValue(txt);

        fila = hoja1.createRow(89);
        celda = fila.createCell(0);
        txt = "Pie diabético(manejo avanzado de herida)";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(90);
        celda = fila.createCell(0);
        txt = "Amputación diabética";
        celda.setCellValue(txt);
        
        fila = hoja1.createRow(91);
        celda = fila.createCell(0);
        txt = "Pre diabeticos";
        celda.setCellValue(txt);


        hoja1.autoSizeColumn(0);
        hoja1.autoSizeColumn(1);
        
        // Fila arriba
        fila = hoja1.createRow(64);
        celda = fila.createCell(1);
        txt = "DIABETICOS";
        celda.setCellValue(txt);
        fila = hoja1.createRow(65);
        celda = fila.createCell(1);
        txt = "Total Ambos Sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(1);
        
        
        fila = hoja1.getRow(64);
        celda = fila.createCell(2);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(65);
        celda = fila.createCell(2);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(2);
        
        fila = hoja1.getRow(64);
        celda = fila.createCell(3);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(65);
        celda = fila.createCell(3);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(3);
        
        
        fila = hoja1.getRow(64);
        celda = fila.createCell(4);
        txt = "HIPERTENSOS";
        celda.setCellValue(txt);
        fila = hoja1.getRow(65);
        celda = fila.createCell(4);
        txt = "Total ambos sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(4);
        
        fila = hoja1.getRow(64);
        celda = fila.createCell(5);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(65);
        celda = fila.createCell(5);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(5);
        
        fila = hoja1.getRow(64);
        celda = fila.createCell(6);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(65);
        celda = fila.createCell(6);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(6);
        
        fila = hoja1.getRow(64);
        celda = fila.createCell(7);
        txt = "DISLIPIDEMICOS";
        celda.setCellValue(txt);
        fila = hoja1.getRow(65);
        celda = fila.createCell(7);
        txt = "Total ambos sexos";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(7);
        
        fila = hoja1.getRow(64);
        celda = fila.createCell(8);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(65);
        celda = fila.createCell(8);
        txt = "Hombres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(8);
        
        fila = hoja1.getRow(64);
        celda = fila.createCell(9);
        txt = "";
        celda.setCellValue(txt);
        fila = hoja1.getRow(65);
        celda = fila.createCell(9);
        txt = "Mujeres";
        celda.setCellValue(txt);
        hoja1.autoSizeColumn(9);
        
        int filas3=1;
        for (CensoCCVnoREM censoIt : censo65yMas) {
            
            fila = hoja1.getRow(66);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPbc());
            
            
            fila = hoja1.getRow(67);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getFallecidos());
            
            fila = hoja1.getRow(68);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPerfilLipidico());
            
            fila = hoja1.getRow(69);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getFondoOjo());
            
            fila = hoja1.getRow(70);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getAtencionPodologica());
            
            fila = hoja1.getRow(71);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getHba1c4());
            
            
            fila = hoja1.getRow(72);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getHba1c3());
            
            fila = hoja1.getRow(73);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getHba1c2());
            
            
            fila = hoja1.getRow(74);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getHba1c1());
            
            
            fila = hoja1.getRow(75);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getCreatinina());
            
            fila = hoja1.getRow(76);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPotasioPlasmatico());
            
            
            fila = hoja1.getRow(77);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getMicroalbuminuria());
            
            fila = hoja1.getRow(78);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getEcg());
            
            fila = hoja1.getRow(79);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getComplicacion());
            
            fila = hoja1.getRow(80);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getRetinopatiaDiabetica());
            
            fila = hoja1.getRow(81);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getInfarto());
            
            fila = hoja1.getRow(82);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getAccidenteVascular());
            
            fila = hoja1.getRow(83);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getCegueraPost());
            
            fila = hoja1.getRow(84);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getHipertrofia());
            
            fila = hoja1.getRow(85);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getNefropatia());
            
            fila = hoja1.getRow(86);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getInsuficienciaRenal());
            
            fila = hoja1.getRow(87);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPieDiabeticoEvaluacion());
            
            fila = hoja1.getRow(88);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPieDiabeticoUlcera());
            
            fila = hoja1.getRow(89);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPieDiabeticoHerida());
            
            fila = hoja1.getRow(90);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getAmputacionDiabetica());
            
            fila = hoja1.getRow(91);
            celda = fila.createCell(filas3);
            celda.setCellValue(censoIt.getPreDiabeticos());
            
            filas3++;
            
        }
        
        
        try {
           // FileOutputStream archivo = new FileOutputStream("resources/documents/censos/CensoPSAM.xlsx");
            
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) facesContext
                    .getExternalContext().getResponse();

            response.reset();
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.setHeader("Content-Disposition",
                    "attachment; filename=CensoNoREMPCV.xlsx");

            ServletOutputStream out = response.getOutputStream();
            libro.write(out);

            facesContext.responseComplete();

         //   libro.write(archivo);
           // archivo.close();
            
        } catch (Exception e) {
        
        }
    
    }
    
    public void preProcessPDF(Object document) throws IOException, BadElementException, DocumentException {
        final Document pdf = (Document) document;
        pdf.open();
        pdf.setPageSize(PageSize.LETTER);
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "resources" + File.separator  + "images" + File.separator + "lawen-logo-pdf.png";
        Image imagen;
        imagen = Image.getInstance(logo);
        imagen.setAlignment(Image.RIGHT);
        imagen.setCompressionLevel(0);
        imagen.scaleAbsolute(117, 40);
        
        pdf.add(imagen);
        
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
        String url = request.getRequestURI().toString();
        Paragraph paragraph = new Paragraph();
        paragraph.setSpacingAfter(15);
        paragraph.setFirstLineIndent(36);
        
        String str2= "cCVMedico";
        if (url.toLowerCase().contains(str2.toLowerCase())){
            paragraph.add("Control Cardiovascular Médico");
        }
        
        paragraph.setAlignment(Element.ALIGN_LEFT);
        pdf.add(paragraph);
    }
    
}