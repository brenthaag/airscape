/**
 *  AirScapeWHF
 *
 *  Copyright 2018 Brent Haag
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
metadata {
	definition (name: "AirScapeWHF", namespace: "brenthaag", author: "Brent Haag") {
		capability "Actuator"
		capability "Configuration"
		capability "Indicator"
		capability "Polling"
		capability "Power Meter"
		capability "Refresh"
		capability "Sensor"
		capability "Switch"
		capability "Switch Level"
		capability "Temperature Measurement"
		
		command "fanSpeedUp"
		command "fanSpeedDn"
		command "fanOff"
		command "fanTimerAdd"
		
		attribute "currentState", "string"
	}
	
	simulator {
		// TODO: define status and reply messages here
	}
	
	preferences {
		input name: "fanIPaddr", type: "string", title: "IP Address", description: "Enter IP address of fan", defaultValue:"", required: true, displayDuringSetup: true
	}
	
	tiles (scale:2) {
		multiAttributeTile(name: "switch", type: "lighting", width: 6, height: 4, canChangeIcon: true) {
			tileAttribute ("device.currentState", key: "PRIMARY_CONTROL") {
				attributeState "default", label:'ADJUSTING', action:"refresh.refresh", icon:"st.Lighting.light24", backgroundColor:"#2179b8", nextState: "turningOff"
				attributeState "SPEED3", label:'SPEED3', action:"switch.off", icon:"st.Lighting.light24", backgroundColor:"#486e13", nextState: "turningOff"
				attributeState "SPEED2", label:'SPEED2', action:"switch.off", icon:"st.Lighting.light24", backgroundColor:"#60931a", nextState: "turningOff"
				attributeState "SPEED1", label:'SPEED1', action:"switch.off", icon:"st.Lighting.light24", backgroundColor:"#79b821", nextState: "turningOff"
				attributeState "OFF", label:'OFF', action:"switch.on", icon:"st.Lighting.light24", backgroundColor:"#ffffff", nextState: "turningOn"
				attributeState "turningOn", action:"switch.on", label:'TURNINGON', icon:"st.Lighting.light24", backgroundColor:"#2179b8", nextState: "turningOn"
				attributeState "turningOff", action:"switch.off", label:'TURNINGOFF', icon:"st.Lighting.light24", backgroundColor:"#2179b8", nextState: "turningOff"
			}
			tileAttribute ("device.level", key: "SECONDARY_CONTROL") {
				attributeState "level", label:'${currentValue}%'
			}
		standardTile("refresh", "device.switch", inactiveLabel: false, decoration: "flat", width: 2, height: 2) {
			state "default", label:"", action:"refresh.refresh", icon:"st.secondary.refresh"
		}
		
		main("switch")
		details("switch",)////FINISH THIS
	}

}

// parse events into attributes
def parse(String description) {
	log.debug "Parsing '${description}'"
	// TODO: handle 'indicatorStatus' attribute
	// TODO: handle 'power' attribute
	// TODO: handle 'switch' attribute
	// TODO: handle 'level' attribute
	// TODO: handle 'temperature' attribute

}

// handle commands
def configure() {
	log.debug "Executing 'configure'"
	// TODO: handle 'configure' command
}

def indicatorWhenOn() {
	log.debug "Executing 'indicatorWhenOn'"
	// TODO: handle 'indicatorWhenOn' command
}

def indicatorWhenOff() {
	log.debug "Executing 'indicatorWhenOff'"
	// TODO: handle 'indicatorWhenOff' command
}

def indicatorNever() {
	log.debug "Executing 'indicatorNever'"
	// TODO: handle 'indicatorNever' command
}

def poll() {
	log.debug "Executing 'poll'"
	// TODO: handle 'poll' command
}

def refresh() {
	log.debug "Executing 'refresh'"
	// TODO: handle 'refresh' command
}

def on() {
	log.debug "Executing 'on'"
	// TODO: handle 'on' command
}

def off() {
	log.debug "Executing 'off'"
	// TODO: handle 'off' command
}

def setLevel() {
	log.debug "Executing 'setLevel'"
	// TODO: handle 'setLevel' command
}
