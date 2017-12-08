import { Component, OnInit, Input } from '@angular/core';
import { DisplayService } from '../display.service';

import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-displayresults',
  templateUrl: './displayresults.component.html',
  styleUrls: ['./displayresults.component.css']
})
export class DisplayresultsComponent implements OnInit {
  
  @Input() fetchedUrls;
  concept:any;
  intent:any;
  constructor(
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
  }

  onClick(value:string,intent:string) {
    //  this.router.navigate(['/user']);
    location.reload();
    console.log(value);
    console.log(intent);
    this.router.navigate(['/sideres/'+value+'/'+intent]);
      
  }
 

}
