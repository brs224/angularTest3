/* tslint:disable:no-unused-variable */

import { TestBed, ComponentFixture,async } from '@angular/core/testing';
import {  Sample1Component } from './sample1.component';

let app: Sample1Component;
let fixture: ComponentFixture<Sample1Component>;

describe('App: Sample1', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({  declarations: [
      Sample1Component
    ],
    })
        .compileComponents()
        .then(() => {
          fixture = TestBed.createComponent(Sample1Component);
          app = fixture.debugElement.componentInstance;
        });
  });

  it('should create the app', async(() => {
    expect(fixture).toBeTruthy();
  }));

  it(`should have as value 'It is a bright new day!!!'`, async(() => {
    expect(app.sampleTitle1).toEqual('app works!');
  }));

  it('should render value in a h2 tag', async(() => {
    fixture.detectChanges();
    let compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h2').textContent).toContain('new day!!!');
  }));
});
