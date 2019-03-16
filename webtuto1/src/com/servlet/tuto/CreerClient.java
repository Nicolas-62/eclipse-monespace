package com.servlet.tuto;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.tuto.Client;

public class CreerClient extends HttpServlet {
	public void doGet( HttpServletRequest request, HttpServletResponse response )	throws ServletException, IOException {
		String message="";
		if(request.getParameter("nomClient")!=null &&
		request.getParameter("prenomClient") !=null &&
		request.getParameter("adresseClient") !=null &&
		request.getParameter("telephoneCLient") !=null &&
		request.getParameter("emailClient") !=null) {
			Client unCLient = new Client(
					request.getParameter("nomClient"),
					request.getParameter("prenomClient"),
					request.getParameter("adresseClient"),
					request.getParameter("telephoneCLient"),
					request.getParameter("emailClient")					
					);
			
			message = "Vos coordonnées ont bien été enregistrées";
			request.setAttribute("client", unCLient);		
		}else {
			message ="Vous devez renseigner tout les champs concernant vos coordonnées <br />"
					+ "<a href=\"creerClient.jsp\">Cliquez ici</a> pour retourner au formulaire";

		}
		
		request.setAttribute("message", message);		
		this.getServletContext().getRequestDispatcher( "/affichageClient.jsp" ).forward( request, response );
		
	}
}
