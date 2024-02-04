package com.example.HackViolet.scrapers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VenmoScraper implements Scraper {

    /**
     * @return
     */
    @Override
    public String getProfileDescription() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://account.venmo.com/_next/data/OYduP97VM8O7kryVOVjfi/en/u/logged-in/Spencer-Paquette-1.json?username=Spencer-Paquette-1"))
                .GET()
                .setHeader("authority", "account.venmo.com")
                .setHeader("accept", "*/*")
                .setHeader("accept-language", "en-US,en;q=0.9")
                .setHeader("cookie", "d_id=f7f6d7700c8a2d9f708b1707063195074; enforce_policy=ccpa; tsrce=identityappsnodeweb; l7_az=dcg14.slc; ts=vreXpYrS%3D1801757595%23D74e5359a18d0ad11cc89c3dcfb158350%26vt%3D74e5359a18d0ad11cc89c3dcfb15834f%26vtyp%3Dnew; ts_c=vr%3D74e5359a18d0ad11cc89c3dcfb158350%26vt%3D74e5359a18d0ad11cc89c3dcfb15834f; x-pp-s=eyJ0IjoiMTcwNzA2MzIxNjQzNCIsImwiOiIwIiwibSI6IjAifQ; v_id=fp01-27769849-7202-4bb5-896e-9cf555216771; s_id=5d1a4f1b-80a0-4433-8f97-69e13d294260; _csrf=mnT7HfF1Y8k9K6QTPrGl-Ygv; api_access_token=1ac2403bf82d2b9d9588a488822c5a2bd15de2d70ec136d5eb4c8abd3386e818; pwv_id_token=eyJraWQiOiI3MjM5YzY5YzhkMDU0YzFmOGNmYmIxMWYyODdlODcwMiIsInR5cCI6IkpXVCIsImFsZyI6IlJTMjU2In0.eyJpc3MiOiJodHRwczovL2FwaS5wYXlwYWwuY29tIiwiYXRfaGFzaCI6IjZTdTRmZVFIb1VoYUE1Y1pXaXJMbnciLCJzdWIiOiJodHRwczovL3d3dy5wYXlwYWwuY29tL3dlYmFwcHMvYXV0aC9pZGVudGl0eS91c2VyL25oUmxTTHNCTU1aMVpQQ3VfcEJQbF9zOWxXYU5COXkyNEF3cmd6LXJkVUEiLCJyb2xlIjoiQ09OU1VNRVIiLCJhbXIiOlsidXNyIiwicHdkIl0sImV4dGVybmFsX2lkIjoiMzE4NDY5Mzk5ODUxODI3MjA1NCIsInNlc3Npb25faW5kZXgiOiJtc1VVNF9KakczVGJxVFdlNVY0aVl6dGhVdEciLCJjbGllbnRfaWQiOiJBVXdSVWFJMDJwajZGaFpaWWJzRTFyOHd3S3lmR250c0NXak0wN2M3NzBXU3NhX203YVc4Z2RMN3BTWmduX1ZRWk9feWhlTzFBNHJoQU51eSIsImFjciI6WyJ1c2VyIl0sImF1ZCI6IkFVd1JVYUkwMnBqNkZoWlpZYnNFMXI4d3dLeWZHbnRzQ1dqTTA3Yzc3MFdTc2FfbTdhVzhnZEw3cFNaZ25fVlFaT195aGVPMUE0cmhBTnV5IiwiY19oYXNoIjoibVhKNFRHSmRfY2VxS1N0UGxmMjFhQSIsImF1dGhfdGltZSI6MTcwNzA2MzIxNiwiYXoiOiJkY2cxNC5zbGMiLCJleHAiOjE3MDcwNjQxMTYsImlhdCI6MTcwNzA2MzIxNiwianRpIjoiVTJBQU0tRy0wRXZOeXR2ZUpUZWdyUTdxVkhnYXBZN3NZa05fN2NiYXFPUW1xTU9tQ29Xbzl6RkpXZFlhSkprWXhVd2RfaUd0b0ZoaFNNdGVuNmFmd29xcU0zRFZycmNmUUZ4TjBQTlRPSVlNckZ4ZTdMYnVaYjBWeFhsV2JmY3cifQ.ZH8xxiXmX9UkNKMQyr2ck_OYUXuHIyGqBLDAnuc5nna29FFR5O_tkxCEfrTDqIeM_jtD2sQTRrKiHW-eweyzZ2sXLZNMfpRboTtojPuDFiR_GdTJBNVrliYJhP99KBv6tm35PVd3u8JVnd58CT737A8cjbcKjwpnZFCWFNdv-NWIdA1yld9GT9t_T6Z1v7_pgD9KlOVNWiTyvJ8nCtVkUcozs53ufYzHI9XISzooLVCck2JgH2NUBGp7SJs0lyiGu4ubxXTzv82oizQKr2Z-gqogqKh7xRnkl8ZwkVpvCaXW5dvn8AvBru5P9qc78gZAh2-l1MhDcmwjlIoac5_zwA; w_fc=5f23ff01-d79b-4376-b320-c330780639c3; cookie_prefs=T%3D1%2CP%3D1%2CF%3D1%2Ctype%3Dexplicit_banner; _dd_s=logs=0&expire=1707064420175&rum=0")
                .setHeader("referer", "https://account.venmo.com/")
                .setHeader("sec-ch-ua", "\"Not A(Brand\";v=\"99\", \"Google Chrome\";v=\"121\", \"Chromium\";v=\"121\"")
                .setHeader("sec-ch-ua-mobile", "?0")
                .setHeader("sec-ch-ua-platform", "\"Windows\"")
                .setHeader("sec-fetch-dest", "empty")
                .setHeader("sec-fetch-mode", "cors")
                .setHeader("sec-fetch-site", "same-origin")
                .setHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/121.0.0.0 Safari/537.36")
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
