import { UrlRelation } from './urlrelation';
import { SocketService } from './socket.service';
import { Component, OnInit,Input } from '@angular/core';
import { DisplayService } from '../display.service';

import { Router, ActivatedRoute, ParamMap } from '@angular/router';
@Component({
  selector: 'app-sideres',
  templateUrl: './sideres.component.html',
  styleUrls: ['./sideres.component.css']
})
export class SideResComponent implements OnInit {

   
  @Input() fetchedUrls;
  concept:any;
  intent:any = "basic";
  anjali:any;
  public inputField = '<enter some text>!';
  public serverResponse: UrlRelation[];
  constructor(private _stompService: SocketService,
    private route: ActivatedRoute,
    private router: Router,
private usersApi:DisplayService) { }
  
  ngOnInit() {
    this.concept = this.route.snapshot.paramMap.get('concept');
    this.intent = this.route.snapshot.paramMap.get('intent');
    console.log(this.concept);
    console.log(this.intent);
    this.usersApi.postquery(this.concept,this.intent).then((res)=>{
      
        this.fetchedUrls = res;
        console.log(res);
      
    })
    // this._stompService.connect();
    this.fake();
  }

  onClick(value:string) {
    //  this.router.navigate(['/user']);
    location.reload();
   
    console.log(value);
    console.log(this.intent);
   
    this.router.navigate(['/sideres/'+value+'/'+this.intent]);
      
  }

  public send(): void {
    console.log("hello"+this.inputField)
    this._stompService.sendMessage(this.inputField);
    console.log("SENT DONE");
    // this._stompService.socketMessages.subscribe( data => {
    //   console.log("data"+data);
    //        this.serverResponse =data;
    //        console.log("serverresponse"+this.serverResponse)
    //      });
    this.anjali=false;
    this.fake();
    console.log("SEND END");
  }

  fake(){
    console.log("INSIDE FAKE")
      setTimeout(()=>{
        console.log("INSIDE TIMEOUT")
        if(this.anjali){
          
   // this.anjali=false;
        }
        if(!this.anjali){
          this._stompService.socketMessages.subscribe( data => {
          console.log("data"+data);
             this.serverResponse =data;
             console.log("serverresponse"+this.serverResponse)
             if(data!=null){
               console.log("DATA IS NOT NULL")
             this.anjali=true;}
           });
           console.log("RECURSION FAKE")
          this.fake();
        }
     }, 1000);
    }
}
