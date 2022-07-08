import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ArtistApiService {

  http :HttpClient;

  constructor(http :HttpClient) { 
    this.http = http;
  }

  save(artist :any) :Observable<any> {
    return this.http.post(environment.apiUrl, artist);
  }

  findAll() :Observable<any> {
    return this.http.get(environment.apiUrl);
  }

  findById(id :number) :Observable<any> {
    return this.http.get(environment.apiUrl + id);
  }
}
