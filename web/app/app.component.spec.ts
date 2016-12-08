/* tslint:disable:no-unused-variable */

import { TestBed, ComponentFixture,async } from '@angular/core/testing';
import { AppComponent } from './app.component';

let app: AppComponent;
let fixture: ComponentFixture<AppComponent>;

describe('App: HelloWorld', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ AppComponent ],
    })
    .compileComponents()
    .then(() => {
      fixture = TestBed.createComponent(AppComponent);
      app = fixture.debugElement.componentInstance;
    });
  });

  it('should create the app', async(() => {
    expect(app).toBeTruthy();
  }));

  it(`should have as title 'Hello World'`, async(() => {
    expect(app.title).toEqual('app works!');
  }));

  it('should render title in a h1 tag', async(() => {
    fixture.detectChanges();
    let compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h1').textContent).toContain('Hello World');
  }));
});
