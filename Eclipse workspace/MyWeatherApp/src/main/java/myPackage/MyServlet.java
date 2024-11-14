package myPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// city name from user
		String cityName = request.getParameter("cityName");
		String cityFullName[] = cityName.split(" ");
		String city=cityFullName[0];
		for(int i=1;i<cityFullName.length;i++) {
			city += "%20"+cityFullName[i];
		}
		
		//api key from https://home.openweathermap.org/api_keys
		String apiKey = "b61ff5acc807e4d50ea9bc2e1ed1c86c";
		
		//URL for open weather api request  
		String apiURL = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
		
		try {
			//API integration
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			//Reading JSON data from network
			InputStream inputStream = conn.getInputStream();
			InputStreamReader reader = new InputStreamReader(inputStream);
			Scanner scanner = new Scanner(reader);
			
			//Storing input data into the string
			StringBuilder responseData = new StringBuilder();
			while(scanner.hasNext()) {
				responseData.append(scanner.nextLine());
			}
			//System.out.println(responseData);
			scanner.close();
			
			//Parsing the JSON response to extract Temperature, Pressure and Humidity
			Gson gson = new Gson();
			JsonObject jsonObj = gson.fromJson(responseData.toString(), JsonObject.class);
			//System.out.println(jsonObj);
			
			//Data & Time 
			long dateTimeStamp = jsonObj.get("dt").getAsLong() * 1000; //time in miliseconds
			String date = new Date(dateTimeStamp).toString();
			
			//Temperature
			double tempKelvin = jsonObj.getAsJsonObject("main").get("temp").getAsDouble();
			int tempCelsius = (int) (tempKelvin-273.15);
			
			//Humidity
			int humidity = jsonObj.getAsJsonObject("main").get("humidity").getAsInt();
			
			//Wind Speed
			double windSpeed = jsonObj.getAsJsonObject("wind").get("speed").getAsDouble();
			
			//Weather condition
			String weather = jsonObj.getAsJsonArray("weather").get(0).getAsJsonObject().get("main").getAsString();
			
			//Set the data as request attribute (to send to JSP page) to Client
			request.setAttribute("city", cityName);
			request.setAttribute("date", date);
			request.setAttribute("temperature", tempCelsius);
			request.setAttribute("humidity", humidity);
			request.setAttribute("windSpeed", windSpeed);
			request.setAttribute("weatherCondition", weather);
			request.setAttribute("weatherData", responseData.toString());
			
			conn.disconnect();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		//Forward the request response to the Weather.jsp page for rendering
		request.getRequestDispatcher("Weather.jsp").forward(request, response);
	}

}
