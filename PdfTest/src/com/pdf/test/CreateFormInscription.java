package com.pdf.test;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateFormInscription {

	public static void main(String[] args) {
		// Pour aide voir : http://tutorials.jenkov.com/java-itext/index.html
		String civil="M.";
		String nom="lourdel";
		String prenom="nicolas";
		String adresse="8 rue de d'artois";
		String ville="Calais";
		String cp="13000";
		String diplomeObtenu="Master finance";
		String diplomeSouhaite="master agro economie";

		Document document = new Document();
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_kk_mm_ss");
		String textDate = date.format(formatter);
		String dest = "pdf/formInscription_" + textDate + ".pdf";
//		String dest = args[0];
		try {
			PdfWriter.getInstance(document, new FileOutputStream(dest));

			document.open();

			// Creation de l'entete (tableau à 3 cellules) :
			float[] pointColumnWidths1 = { 20f, 35f, 65f, };
			PdfPTable entete = new PdfPTable(pointColumnWidths1);
			entete.setWidthPercentage(100);

			// Ligne 1, cellule 1 : image
			// Creating an ImageData object
			Image image = Image.getInstance("img/logo.jpeg");
			// Adding image to the document
			/*
			 * You do so by passing the image to the PdfPCell constructor, 
			 * along with a boolean saying whether the image should fit the cell (true),
			 *  or the cell should fit the image (false). 
			 */
			PdfPCell cellLogo = new PdfPCell(image, true);
			cellLogo.setBorder(0);
			entete.addCell(cellLogo);

			// Ligne 1, cellule 2 : titre du document
			PdfPCell cellHeader = new PdfPCell();
			cellHeader.setBorder(0);
			Paragraph paraHeader = new Paragraph();

			Font fontHeader = new Font(Font.FontFamily.HELVETICA, 14, Font.NORMAL);
			paraHeader.setFont(fontHeader);
			Paragraph textEcole = new Paragraph("LKRT");
			Paragraph textDossier = new Paragraph("DOSSIER INSCRIPTION");
			Paragraph textAnnee = new Paragraph("ANNEE 2019 - 2020");
			paraHeader.add(textEcole);
			paraHeader.add(textDossier);
			paraHeader.add(textAnnee);
			cellHeader.addElement(paraHeader);		
			entete.addCell(cellHeader);

			// Ligne 1, cellule 3 : cadre admin
            PdfPCell cellCadreAdmin = new PdfPCell();
            cellCadreAdmin.setBorder(0);
            // tableau imbriqué dans la cellule
            PdfPTable tableCadreAdmin = new PdfPTable(1);
            tableCadreAdmin.setHorizontalAlignment(Element.ALIGN_RIGHT);
            PdfPCell cellHeaderAdmin = new PdfPCell(new Paragraph("Cadre réservé à l'administration"));
            cellHeaderAdmin.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cellHeaderAdmin.setHorizontalAlignment(Element.ALIGN_CENTER);
            tableCadreAdmin.addCell(cellHeaderAdmin);
            
            PdfPCell cellCorpAdmin = new PdfPCell();
            Paragraph paraCorpAdmin = new Paragraph();
            paraCorpAdmin.add(new Paragraph("reception : ..............................................."));
            paraCorpAdmin.add(new Paragraph("observations : ........................................."));
            paraCorpAdmin.add(new Paragraph("................................................................."));
            paraCorpAdmin.add(new Paragraph("................................................................"));
            paraCorpAdmin.add(new Paragraph("enregistrement : ......................................"));
            paraCorpAdmin.setSpacingAfter(10);
            cellCorpAdmin.addElement(paraCorpAdmin);
            tableCadreAdmin.addCell(cellCorpAdmin);
            cellCadreAdmin.addElement(tableCadreAdmin);
            entete.addCell(cellCadreAdmin);
			document.add(entete);
			// fin de l'entete
			
			// cadre informations
			
			// titre
			Font fontTitres = new Font(Font.FontFamily.HELVETICA, 16, Font.ITALIC);
			Paragraph titreInfos = new Paragraph();
			titreInfos.setSpacingBefore(30);
			titreInfos.setSpacingAfter(5);
			titreInfos.setFont(fontTitres);
			titreInfos.add(new Phrase("Vos Informations"));
			document.add(titreInfos);
			// informations tableau de 2 cellules avec les infos et une cellule pour la photo
			float[] largeurCellules = { 80f, 20f };
			PdfPTable tabInfos = new PdfPTable(largeurCellules);
			tabInfos.setWidthPercentage(100);
			// premiere cellule
			PdfPCell cellInfos = new PdfPCell();
			cellInfos.setBorder(0);
			Paragraph infos = new Paragraph();
			Paragraph paraCivilite = new Paragraph();
			paraCivilite.add(new Phrase("Civilite : "));
			if("M.".equals(civil))
				paraCivilite.add(new Phrase("....Monsieur"));
			else
				paraCivilite.add(new Phrase("....Madame"));
			infos.add(paraCivilite);
			Paragraph paraNom = new Paragraph();
			paraNom.add(new Phrase("Nom : "));
			paraNom.add(new Phrase("...."+nom));
			infos.add(paraNom);
			
			Paragraph paraPrenom = new Paragraph();
			paraPrenom.add(new Phrase("Prenom : "));
			paraPrenom.add(new Phrase("...."+prenom));
			infos.add(paraPrenom);	
			
			Paragraph paraAdresse = new Paragraph();
			paraAdresse.add(new Phrase("Adresse : "));
			paraAdresse.add(new Phrase("...."+adresse));
			infos.add(paraAdresse);	
			
			Paragraph paraVille = new Paragraph();
			paraVille.add(new Phrase("Ville : "));
			paraVille.add(new Phrase("...."+ville));
			infos.add(paraVille);
			
			Paragraph paraCp = new Paragraph();
			paraCp.add(new Phrase("Code Postal : "));
			paraCp.add(new Phrase("...."+cp));
			infos.add(paraCp);			
			
			cellInfos.addElement(infos);		
			tabInfos.addCell(cellInfos);	
			// deuxieme cellule
			PdfPCell cellPhoto = new PdfPCell();
//			cellPhoto.setBorder(2);
			cellPhoto.addElement(new Paragraph("    Votre photo"));
			cellPhoto.setHorizontalAlignment(Element.ALIGN_CENTER);
			cellPhoto.setVerticalAlignment(Element.ALIGN_MIDDLE);
			tabInfos.addCell(cellPhoto);
			document.add(tabInfos);

			Paragraph titreDiplomes = new Paragraph();
			titreDiplomes.setSpacingBefore(20);
			titreDiplomes.setSpacingAfter(5);
			titreDiplomes.setFont(fontTitres);
			titreDiplomes.add(new Phrase("Diplomes"));
			document.add(titreDiplomes);
			
			Paragraph diplomes = new Paragraph();
			
			Paragraph diploObt = new Paragraph();
			diploObt.add(new Phrase("Diplome Obtenu : "));
			diploObt.add(new Phrase("..............................."+diplomeObtenu+"......................................................"));
			diplomes.add(diploObt);
			
			Paragraph diploSou = new Paragraph();
			diploSou.add(new Phrase("Diplome Souhaité : "));
			diploSou.add(new Phrase(".............................."+diplomeSouhaite+"............................................."));
			diplomes.add(diploSou);		
			document.add(diplomes);
			
			Paragraph titreSituation = new Paragraph();
			titreSituation.setSpacingBefore(20);
			titreSituation.setSpacingAfter(5);
			titreSituation.setFont(fontTitres);
			titreSituation.add(new Phrase("Votre Situation"));
			document.add(titreSituation);
			
			
			Paragraph profession = new Paragraph();
			profession.add(new Phrase("Profession : ......................................................................................................................."));
			document.add(profession);
			
			Paragraph nbAnneeExp = new Paragraph();
			nbAnneeExp.add(new Phrase("Nombre d'années d'expérience : ......................................................................................."));
			document.add(nbAnneeExp);
			
			Paragraph titreInscription = new Paragraph();
			titreInscription.setSpacingBefore(20);
			titreInscription.setSpacingAfter(5);
			titreInscription.setFont(fontTitres);
			titreInscription.add(new Phrase("Votre Inscription"));
			document.add(titreInscription);	
	
			Paragraph typeFinancement = new Paragraph();
			typeFinancement.add(new Phrase("Type de financement : ......................................................................................................."));
			document.add(typeFinancement);
			
			Paragraph cout = new Paragraph();
			cout.setSpacingAfter(20);
			cout.add(new Phrase("                                                                                                      Cout total : ......499,99 €"));
			document.add(cout);
			// conditions générales
			PdfPTable ConditionsGenerales = new PdfPTable(1);
			ConditionsGenerales.setWidthPercentage(100);
			ConditionsGenerales.setSpacingBefore(20);
			
			PdfPCell cellConditions = new PdfPCell();
			
			Paragraph conditions = new Paragraph();

			Font conditionFontTitre = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
			Paragraph conditionTitre = new Paragraph();
			conditionTitre.setFont(conditionFontTitre);
			conditionTitre.add(new Phrase("Conditions générales"));
			conditions.add(conditionTitre);
			
			Font conditionFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
			Paragraph condition1 = new Paragraph();
			condition1.setFont(conditionFont);
			condition1.add(new Phrase("1 - L’ouverture d’une Formation ou d’une Unité d’Enseignement (UE) est conditionnée par le nombre d’auditeurs."));
			conditions.add(condition1);
			Paragraph condition2 = new Paragraph();
			condition2.setFont(conditionFont);
			condition2.add(new Phrase("2 - L’inscription individuelle ne donne pas droit à une attestation de présence"));
			conditions.add(condition2);
			Paragraph condition3 = new Paragraph();
			condition3.setFont(conditionFont);
			condition3.add(new Phrase("3 - Les tarifs applicables par l'école sont susceptibles d’être révisés chaque année universitaire."));
			conditions.add(condition3);						
			Paragraph condition4 = new Paragraph();
			condition4.setFont(conditionFont);
			condition4.add(new Phrase("4 - Pour les ressortissants étrangers d’un pays non membre de la communauté européenne, il est nécessaire de fournir une " + 
					"copie du titre de séjour, couvrant l’ensemble de la période de formation"));
			conditions.add(condition4);
			conditions.setSpacingAfter(10);
			
			cellConditions.addElement(conditions);
			ConditionsGenerales.addCell(cellConditions);
			document.add(ConditionsGenerales);
			
			PdfPTable tabSignature = new PdfPTable(1);
			tabSignature.setSpacingBefore(20);
			tabSignature.setWidthPercentage(100);
			
			PdfPCell cellSignature = new PdfPCell();
			cellSignature.setBorder(0);
			Paragraph dateSignature = new Paragraph(new Phrase("date : __/__/____"));
			dateSignature.setAlignment(Element.ALIGN_RIGHT);;
			cellSignature.addElement(dateSignature);
			
			Paragraph lieuSignature = new Paragraph(new Phrase("lieu : .............................."));
			lieuSignature.setAlignment(Element.ALIGN_RIGHT);;
			cellSignature.addElement(lieuSignature);	
			
			Font uneSignatureFont = new Font(Font.FontFamily.HELVETICA, 9, Font.ITALIC);
			Paragraph uneSignature = new Paragraph();
			uneSignature.setFont(uneSignatureFont);
			uneSignature.add(new Phrase("Signature précédée de la mention «Lu et approuvé»"));
			uneSignature.setAlignment(Element.ALIGN_RIGHT);;
			cellSignature.addElement(uneSignature);
			tabSignature.addCell(cellSignature);
			document.add(tabSignature);
			
			
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println("added");
	}

}
