import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  baseUrl:string='http://3.109.2.121:8080/api/';
  constructor(private http:HttpClient) { }

  registerData(obj:any){
      return  (this.http.post(`${this.baseUrl}signup` ,obj,{
        responseType:"text"
       }));
  }

   login(obj:any){
      return (this.http.post(`${this.baseUrl}loginUser`,obj))
   }

   getAllEmpRecord(){
     return (this.http.get(`${this.baseUrl}getAllEmployee`))
   }

   getParticularRecordById(id:any){
     return (this.http.get(`${this.baseUrl}getparticular-record/${id}`))
   }

   getAllCountry(){
    return (this.http.get(`${this.baseUrl}getallcountry`));
   }

   postEmpData(obj:any){
     return (this.http.post(`${this.baseUrl}addEmployee`,obj,{
        responseType:"text"
      }));
   }
   updateEmpData(obj:any){
    return (this.http.put(`${this.baseUrl}updateEmployee`,obj,{
      responseType:"text"
    }));
   }

   deleteEmpData(id:any){
    return (this.http.delete(`${this.baseUrl}deleteEmployee/${id}`,{
      responseType:"text"
    }));
   }
}
