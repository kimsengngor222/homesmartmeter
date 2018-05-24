
<div class="uk-container">
	<div class="main-content__wrapper">
		<div class="uk-switcher section_container">

			<!-- Dashboard content div -->
			<div class="section_content dashboard">
				<div class="inner">
					<div
						class="card-box__outter uk-flex uk-flex-wrap uk-flex-wrap-around"
						id="dashboardDiv"></div>
				</div>
			</div>
			<!-- /Dashboard content div -->

			<!-- source content div -->
			<div class="section_content source">

				<!-- Trigger sidebar -->
				<div id="sidebarTrigger">
					<?xml version="1.0" encoding="iso-8859-1"?>
					<!-- Generator: Adobe Illustrator 16.0.0, SVG Export Plug-In . SVG Version: 6.00 Build 0)  -->
					<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
					<svg xmlns="http://www.w3.org/2000/svg"
						xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1"
						id="Capa_1" x="0px" y="0px" width="512px" height="512px"
						viewBox="0 0 507.961 507.961"
						style="enable-background: new 0 0 507.961 507.961;"
						xml:space="preserve">
                                    <g>
                                        <g>
                                            <path
							d="M18.36,156.061H489.6c10.141,0,18.361-8.219,18.361-18.36v-97.92c0-10.141-8.221-18.36-18.361-18.36H18.36    C8.219,21.42,0,29.64,0,39.781v97.92C0,147.841,8.219,156.061,18.36,156.061z M333.766,73.44h129.316    c8.451,0,15.301,6.848,15.301,15.3c0,8.452-6.85,15.3-15.301,15.3H333.766c-8.451,0-15.299-6.848-15.299-15.3    C318.467,80.289,325.314,73.44,333.766,73.44z"
							fill="#002c57" />
                                            <path
							d="M18.36,321.3H489.6c10.141,0,18.361-8.219,18.361-18.359v-97.92c0-10.141-8.221-18.36-18.361-18.36H18.36    C8.219,186.661,0,194.88,0,205.021v97.92C0,313.082,8.219,321.3,18.36,321.3z M199.126,238.681h263.956    c8.451,0,15.301,6.848,15.301,15.3c0,8.451-6.85,15.3-15.301,15.3H199.126c-8.452,0-15.3-6.849-15.3-15.3    C183.827,245.529,190.675,238.681,199.126,238.681z"
							fill="#002c57" />
                                            <path
							d="M18.36,486.541H489.6c10.141,0,18.361-8.219,18.361-18.36v-97.92c0-10.141-8.221-18.359-18.361-18.359H18.36    C8.219,351.901,0,360.12,0,370.26v97.92C0,478.322,8.219,486.541,18.36,486.541z M278.686,403.92h184.396    c8.451,0,15.301,6.849,15.301,15.3c0,8.452-6.85,15.301-15.301,15.301H278.686c-8.451,0-15.299-6.849-15.299-15.301    C263.387,410.769,270.234,403.92,278.686,403.92z"
							fill="#002c57" />
                                        </g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                    <g>
                                    </g>
                                </svg>
				</div>
				<!-- /Trigger sidebar -->

				<div class="inner uk-flex-inline uk-flex-wrap">
					<div class="sidebar uk-flex">
						<ul class="accommodation_list"
							uk-switcher="connect: .source_region">

						</ul>
					</div>

					<div class="content uk-flex-1">

						<div class="calendar_bar"></div>
						<div id="regionDiv" class="uk-switcher source_region"></div>

						<!-- <div class="clear_cache_wrapper">
							<button id="clearCacheSource"
								class="uk-button uk-button-primary uk-button-medium">Refresh</button>
						</div> -->
					</div>

				</div>
			</div>
			<!-- /source content div -->




			<!-- Event content div -->
			<div class="section_content event">



				<div class="inner uk-flex-inline uk-flex-wrap">



					<div class="content uk-flex-1">
						<div>
							<div id="eventListDiv"
								class="event_container card-box__outter uk-flex uk-flex-wrap uk-flex-wrap-around">

							</div>

							<div class="uk-padding uk-text-center">
								<a class="uk-button uk-button-default button-circle"
									href="#event_form_modal" uk-toggle> <i class="fa fa-plus"></i>
								</a>
							</div>

						</div>


					</div>

				</div>

				<div id="event_form_modal" class="uk-flex-top" uk-modal>
					<div class="uk-modal-dialog uk-margin-auto-vertical">
						<button class="uk-modal-close-default" type="button" uk-close></button>
						<div class="uk-modal-header">
							<h2 class="uk-modal-title uk-text-center">Create New Event</h2>
						</div>
						<div class="uk-modal-body">
							<div class="ruegion_from_flex uk-margin">
								<div
									class="uk-flex uk-flex-wrap uk-flex-wrap-around uk-flex-between uk-form-stacked">
									<div class="input-item">
										<label class="uk-form-label" for="event_location">Location:</label>
										<div class="uk-form-controls">
											<select class="uk-select select_location" name="location"
												id="event_location">
											</select>
										</div>
									</div>

									<div class="input-item">
										<label class="uk-form-label" for="event_region">
											Region:</label>
										<div class="uk-form-controls">
											<select class="uk-select select_region" name="region"
												id="event_region">

											</select>
										</div>
									</div>

									<div class="input-item">
										<label class="uk-form-label" for="event_room"> Room
											ID:</label>
										<div class="uk-form-controls">
											<select class="uk-select select_room" name="rroom"
												id="event_room">

											</select>
										</div>
									</div>
								</div>
							</div>


							<form name="event" id="boardsubmit">
								<div class="uk-padding-small uk-flex uk-flex-middle">
									<label class="uk-form-label"><i class="fa fa-bolt"
										style="margin-right: 10px;"></i> Electricity usage greater
										than<i class="gt-icon"></i></label>
									<div class="uk-inline uk-flex-1">
										<span class="text-form-icon uk-form-icon uk-form-icon-flip">kwh</span>
										<input type="number" onkeypress="return event.charCode >= 48"  onkeydown="javascript: return event.keyCode == 69 ? false : true"
											name="electric_gt" class="uk-input" placeholder=""
											id="electricc" >
									</div>
								</div>
								<div class="uk-padding-small uk-flex uk-flex-middle">
									<label class="uk-form-label"><i class="fa fa-tint"
										style="margin-right: 10px;"></i> Water usage greater than<i
										class="gt-icon"></i></label>
									<div class="uk-inline uk-flex-1">
										<span class="text-form-icon uk-form-icon uk-form-icon-flip">m<sup>3</sup></span>
										<input type="number" onkeypress="return event.charCode >= 48"  onkeydown="javascript: return event.keyCode == 69 ? false : true"
											name="water_gt" class="uk-input" placeholder="" id="waterr" >
									</div>
								</div>
								<div class="uk-padding-small uk-flex ">
									<label class="uk-form-label"><i class="fa fa-comments"
										style="margin-right: 10px;"></i> Message <i class="gt-icon"></i>
									</label>
									<textarea placeholder="Type your message..." style="border-radius:10px"
										class="uk-textarea uk-flex-1 uk-inline" rows="5" cols=""
										id="messagee"></textarea>
								</div>
								<div class="uk-padding-small uk-flex uk-flex-middle">
									<label class="uk-form-label"><i class="fa fa-envelope"
										style="margin-right: 10px;"></i> Email <i class="gt-icon"></i>
									</label> <input type="email" name="email_adress" class="uk-input"
										placeholder="Email address" id="emaill">
								</div>
								<div class="uk-padding-small uk-align-right">
									<input class="uk-button uk-button-default uk-modal-close"
										type="submit" id="cancel" value="Cancel">
									<input id="createEventBtn" class="uk-button uk-button-primary"
										type="submit" value="Save">
								</div>
							</form>

							<!-- <form name="water"
								class="uk-margin uk-flex uk-flex-middle uk-flex-inline uk-width-1-1">
								<label class="uk-form-label uk-flex-none"><i
									class="fa fa-tint" style="margin-right: 10px;"></i> Water usage
									greater than<i class="gt-icon"></i></label>
								<div class="uk-inline">
									<span class="text-form-icon uk-form-icon uk-form-icon-flip">m<sup>3</sup></span>
									<input type="number" onkeypress="return event.charCode >= 48" min="1" name="water_gt" class="uk-input"
										placeholder="" id="waterr" maxlength="15" pattern="\d*" >
								</div>
							</form> -->

							<!-- <form class="uk-margin uk-flex uk-flex-inline uk-width-1-1">
								<label class="uk-form-label uk-flex-none"><i
									class="fa fa-comments" style="margin-right: 10px;"></i> Message
									<i class="gt-icon"></i> </label>
								<textarea placeholder="Type your message..."
									class="uk-textarea uk-flex-1" rows="5" cols="" id="messagee"></textarea>
							</form> -->
							<!-- 
							<form name="email"
								class="uk-margin uk-flex uk-flex-middle uk-flex-inline uk-width-1-1">
								<label class="uk-form-label uk-flex-none"><i
									class="fa fa-envelope" style="margin-right: 10px;"></i> Email <i
									class="gt-icon"></i> </label> <input type="email" name="email_adress"
									class="uk-input" placeholder="Email address" id="emaill" >
								


							</form> 

 -->



						</div>



					</div>
				</div>
			</div>
			<!-- /Event content div -->

			<!-- Export content div -->
			<div class="section_content export">
				<form action="exportoutput?room=rroom" name="exportValidation" method="POST"
					class="region_from_flex" id="export_form">
					<div
						class="uk-flex uk-flex-wrap uk-flex-wrap-around uk-flex-between uk-form-stacked">
						<div class="input-item">
							<label class="uk-form-label uk-padding-small"
								for="export_location">Location:</label>
							<div class="uk-form-controls">
								<select class="uk-select select_location" name="location"
									id="export_location">

								</select>
							</div>
						</div>

						<div class="input-item">
							<label class="uk-form-label uk-padding-small" for="export_region">
								Region:</label>
							<div class="uk-form-controls">
								<select class="uk-select select_region" name="region"
									id="export_region">

								</select>
							</div>
						</div>

						<div class="input-item">
							<label class="uk-form-label uk-padding-small" for="export_room">
								Room ID:</label>
							<div class="uk-form-controls">
								<select class="uk-select select_room" name="rroom"
									id="export_room">

								</select>
							</div>
						</div>
					
						<div class="input-item">
							<label class="uk-form-label uk-padding-small" for="export_from">From:</label>
							<div class="uk-form-controls">
								<input class="uk-input" type="text" name="from" id="export_from" readonly>
							</div>
						</div>

						<div class="input-item">
							<label class="uk-form-label uk-padding-small" for="export_until">Until</label>
							<div class="uk-form-controls">
								<input class="uk-input" type="text" name="until" id="export_until" readonly>
							</div>
						</div>

						<div
							class="input-item uk-flex uk-flex-middle uk-flex-column-reverse">
							<button class="uk-button uk-button-medium uk-button-default"
								type="submit" value="Submit">Submit</button>
						</div>
						
					</div>

				</form>

				<div class="uk-section">
					<div class="uk-overflow-auto">
						<table
							class="uk-table uk-table-hover uk-table-striped uk-table-justify uk-table-divider"
							id="room_export_table">
							<thead>
								<tr>
									<th>ID</th>
									<th>Name</th>
									<th>Power</th>
									<th>Water</th>
								</tr>
							</thead>
							<tbody id="export_table">

							</tbody>
						</table>
					</div>
				</div>

				<div class="uk-text-center uk-padding-small">
					<button id="roomExportBtn"
						class="uk-button uk-button-medium uk-button-primary uk-hidden">
						Export</button>
				</div>

			</div>
			<!-- /Export content div -->

			<!-- BoardRegistration -->




			<div class="section_content board">

				<ul
					class="uk-grid uk-grid-collapse uk-tab uk-tab-animation uk-padding"
					uk-switcher="connect: .boardregister_container" data-uk-tab>
					<li class="uk-width-1-4 uk-width-1-4 uk-toggle uk-active"
						id="borad-location"><a href="#">Location</a></li>
					<li class="uk-width-1-4" id="borad-region"><a href="#">Region</a></li>
					<li class="uk-width-1-4" id="borad-room"><a href="#"> Room</a></li>
					<li class="uk-width-1-4" id="board-board"><a href="#">Board</a></li>
				</ul>

				<div
					class="region_from_flex uk-margin uk-switcher boardregister_container">
					<!-- Location -->
					<form method="POST" class="region_from_flex" id="boardlocation">
						<div
							class="uk-flex uk-flex-wrap uk-flex-wrap-around uk-flex-between uk-form-stacked uk-grid">
							<div class="input-item uk-width-1-2 ">
								<label class="uk-form-label uk-padding-small"
									for="board_locationid3"> Location ID:</label>
								<div class="uk-form-controls ">
									<input type="number" name="boardlocid"
										onkeypress="return event.charCode >= 48"  onkeydown="javascript: return event.keyCode == 69 ? false : true" min="1"
										class="uk-input " id="board_locationid3">
								</div>
							</div>
							<div class="input-item uk-width-1-2">
								<label class="uk-form-label uk-padding-small"
									for="board_locationname3"> Location Name:</label>
								<div class="uk-form-controls">
									<input type="text" name="boardlocname" class="uk-input "
										id="board_locationname3">
								</div>
							</div>
						</div>

						<div class="uk-text-center uk-padding">
							<input class="uk-button uk-button-primary" type="submit"
								value="Register">
						</div>
					</form>



					<!-- Region -->
					<form method="POST" class="region_from_flex" id="boardregion">
						<div
							class="uk-flex uk-flex-wrap uk-flex-wrap-around uk-flex-between uk-form-stacked uk-grid">
							<div class="input-item uk-width-1-3">
								<label class="uk-form-label uk-padding-small"
									for="board_location2">Location:</label>
								<div class="uk-form-controls">
									<select class="uk-select select_location" name="location"
										id="board_location2">

									</select>
								</div>
							</div>
							<div class="input-item uk-width-1-3">
								<label class="uk-form-label uk-padding-small"
									for="board_regionid2"> Region ID:</label>
								<div class="uk-form-controls">
									<input type="number" onkeypress="return event.charCode >= 48"  onkeydown="javascript: return event.keyCode == 69 ? false : true" 
										min="1" name="boardregionid" class="uk-input"
										id="board_regionid2">
								</div>
							</div>
							<div class="input-item uk-width-1-3">
								<label class="uk-form-label uk-padding-small"
									for="board_regionname2 "> Region Name:</label>
								<div class="uk-form-controls">
									<input type="text" name="boardregionname" class="uk-input"
										id="board_regionname2">
								</div>
							</div>
						</div>

						<div class="uk-text-center uk-padding">
							<input class="uk-button uk-button-primary" type="submit"
								value="Register">
						</div>
					</form>
					<!-- Room -->
					<form method="POST" class="region_from_flex" id="boardroom">
						<div
							class="uk-flex uk-flex-wrap uk-flex-wrap-around uk-flex-between uk-form-stacked uk-grid">
							<div class="input-item uk-width-1-4">
								<label class="uk-form-label uk-padding-small"
									for="board_location1">Location:</label>
								<div class="uk-form-controls">
									<select class="uk-select select_location" name="location"
										id="board_location1">

									</select>
								</div>
							</div>

							<div class="input-item uk-width-1-4">
								<label class="uk-form-label uk-padding-small"
									for="board_region1"> Region:</label>
								<div class="uk-form-controls">
									<select class="uk-select select_region" name="region"
										id="board_region1">

									</select>
								</div>
							</div>
							<div class="input-item uk-width-1-4">
								<label class="uk-form-label uk-padding-small"
									for="board_roomid1"> Room ID:</label>
								<div class="uk-form-controls">
									<input type="number" onkeypress="return event.charCode >= 48"  onkeydown="javascript: return event.keyCode == 69 ? false : true" 
										min="1" name="roomid" class="uk-input" id="board_roomid1">
								</div>
							</div>
							<div class="input-item uk-width-1-4">
								<label class="uk-form-label uk-padding-small"
									for="board_roomname1"> Room Name:</label>
								<div class="uk-form-controls">
									<input type="text" name="roomname" class="uk-input"
										id="board_roomname1">
								</div>
							</div>
						</div>

						<div class="uk-text-center uk-padding">
							<input class="uk-button uk-button-primary" type="submit"
								value="Register">
						</div>
					</form>


					<!-- Board -->


					<form method="POST" class="region_from_flex" id="boardboard">
						<div
							class="uk-flex uk-flex-wrap uk-flex-wrap-around uk-flex-between uk-form-stacked uk-grid">
							<div class="input-item uk-width-1-4">
								<label class="uk-form-label uk-padding-small"
									for="board_location">Location:</label>
								<div class="uk-form-controls">
									<select class="uk-select select_location" name="location"
										id="board_location">

									</select>
								</div>
							</div>

							<div class="input-item uk-width-1-4">
								<label class="uk-form-label uk-padding-small" for="board_region">
									Region:</label>
								<div class="uk-form-controls">
									<select class="uk-select select_region" name="region"
										id="board_region">

									</select>
								</div>
							</div>

							<div class="input-item uk-width-1-4">
								<label class="uk-form-label uk-padding-small" for="board_room">
									Room ID:</label>
								<div class="uk-form-controls">
									<select class="uk-select select_room" name="rroom"
										id="board_room">

									</select>
								</div>
							</div>

							<div class="input-item uk-width-1-4">
								<label class="uk-form-label uk-padding-small" for="board_room">
									BoardMAC</label>
								<div class="uk-form-controls">
									<input type="text" name="boardmac" class="uk-input" maxlength="17"
										id="board_mac">
								</div>
							</div>
						</div>

						<div class="uk-text-center uk-padding">
							<input class="uk-button uk-button-primary" type="submit"
								value="Register">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
