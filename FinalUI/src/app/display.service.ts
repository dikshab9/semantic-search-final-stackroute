
import { SearchComponent } from './search/search.component';
import { Injectable } from '@angular/core';
import { Headers,Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
@Injectable()
export class DisplayService{
    

    query: string = "";
    private webUrl = 'http://localhost:8080/geturl';
    
    private headers = new Headers({'Content-Type': 'application/json',

    'Access-Control-Allow-Origin': '*'});
    constructor (private http: Http){}
    
    setQuery(value){
        this.query=value;
    }
    // getUrls(url:any,intent:any): Promise<void> {
    //     console.log("hi")
    //     //  return this.http.get('https://www.googleapis.com/customsearch/v1?key=AIzaSyAl4scItyrUcR2RXP_BANo4_JJaME9h1lE&cx=001526183543954148516:le1j-wjnwkg&q=java%20interface')
    //      return this.http.get('http://172.23.238.178:8080/v1.0/semantic/neo4jconceptservice/geturlintent/'+url+'/'+intent)
    //                     .toPromise()
    //                     .then((res)=>res.json(),
    //                           (err)=>err.json())
    //   }

    postquery(url:any,intent:any): Promise<void> {
        console.log("hi")
        //  return this.http.get('https://www.googleapis.com/customsearch/v1?key=AIzaSyAl4scItyrUcR2RXP_BANo4_JJaME9h1lE&cx=001526183543954148516:le1j-wjnwkg&q=java%20interface')
         return this.http.post('http://172.23.238.157:8051/spellcheck/query?query='+url,JSON.stringify({}))
                        .toPromise()
                        .then(
                            (res)=>res.text(),
                              (err)=>err.json())
      }

    //   getRestaurants(): Promise<void> {
    //     return this.http.get('http://172.23.238.178:8080/semantic/fetchresults')
    //                     .toPromise()
    //                     .then((res)=>res.json(),
    //                           (err)=>err.json())
    //   }


    postquery1(domain:any,concept:any): Promise<void> {
        console.log("hi")
        //  return this.http.get('https://www.googleapis.com/customsearch/v1?key=AIzaSyAl4scItyrUcR2RXP_BANo4_JJaME9h1lE&cx=001526183543954148516:le1j-wjnwkg&q=java%20interface')
         return this.http.post('https://172.23.238.224:8080/domainexpert/'+domain+'/'+concept,JSON.stringify({}),{headers: this.headers})
                        .toPromise()
                        .then(
                            (res)=>res.text(),
                              (err)=>err.json())
      }

    //   getRestaurants(): Promise<void> {
    //     return this.http.get('http://172.23.238.178:8080/semantic/fetchresults')
    //                     .toPromise()
    //                     .then((res)=>res.json(),
    //                           (err)=>err.json())
    //   }

}