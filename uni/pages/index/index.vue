<template>
	<!-- 页面背景图片自动切换 -->
	<view class="content" style="position: relative; height: 100vh;">
		<view style="z-index: 1;">
		<uni-swiper-dot class="uni-swiper-dot-box" >
			<swiper class="swiper-box">
				<swiper-item v-for="(item, index) in info">
					<view :class="item.colorClass" class="swiper-item">
						<image class="image" :src="item.url" mode="aspectFill" :draggable="false"/>
					</view>
				</swiper-item>
			</swiper>
		</uni-swiper-dot></view>
		
		<!-- 标题 -->
		<view style="z-index: 2; position: absolute; top: 1000rpx; left: 10px;">
			<text style="font-size: 40px; font-weight: bold; color: #5d9fa2; text-shadow: -5px 5px 5px #626262">Cross</text>
			<text style="font-size: 40px; font-weight: bold; color: #ffffff; text-shadow: -5px 5px 5px #626262">-time\n</text>
			<text style="font-size: 15px; color: #ffffff; text-shadow: -5px 5px 5px #626262">随时随地开始语言学习吧！</text>
		</view>
		
		<!-- 开始按钮 -->

		<view class="container" style="z-index: 3; position: absolute; top: 1200rpx; right: 0;">
			<view @click="gopage">
				<image style="width: 220rpx; height: 100rpx;" src="../../static/start.png" open-type="getUserProfile"></image>
			</view>
		</view>
		
		<!-- 选择语言提示框 -->
		<view style="width: 50%; height: 100rpx; margin: auto; z-index: 4; position: absolute; top: 1200rpx;">	
			<xfl-select 
				:list="list"
				:clearable="false"
				:showItemNum="5" 
				:listShow="false"
				:isCanInput="false"  
				:style_Container="listBoxStyle"
				:placeholder = "'placeholder'"
				:initValue="'请选择语言'"
				:selectHideType="'independent'"
			style=" background-color: rgba(255, 134, 64, 0.5); height: 100rpx;">
			</xfl-select>
		</view>
		
	</view>
</template>

<script>
	import xflSelect from '../../components/xfl-select/xfl-select.vue';
	export default {
		components: {},
		data() {
			return {
				listBoxStyle: `height: 40px; font-size: 16px;`,
				list: [
					'中文',
					'英语',
					'韩语',
					{value: '日语', disabled: true},
					'德语',
					'西班牙语',
					'意大利语',
					'葡萄牙语',
				],
				userInfo: {},
				hasUserInfo: false,
				canIUseGetUserProfile: false,
				code:'',
				openid: '',
				session_key: '',
				encryptedData: ',',
				iv: '',
				info: [{
						url: '../../static/homepage1.png',
					},
					{
						url: '../../static/homepage2.jpg',
					},
				],
				dotStyle: [{
						backgroundColor: 'rgba(0, 0, 0, .3)',
						border: '1px rgba(0, 0, 0, .3) solid',
						color: '#fff',
						selectedBackgroundColor: 'rgba(0, 0, 0, .9)',
						selectedBorder: '1px rgba(0, 0, 0, .9) solid'
					},
					{
						backgroundColor: 'rgba(255, 90, 95,0.3)',
						border: '1px rgba(255, 90, 95,0.3) solid',
						color: '#fff',
						selectedBackgroundColor: 'rgba(255, 90, 95,0.9)',
						selectedBorder: '1px rgba(255, 90, 95,0.9) solid'
					},
					{
						backgroundColor: 'rgba(83, 200, 249,0.3)',
						border: '1px rgba(83, 200, 249,0.3) solid',
						color: '#fff',
						selectedBackgroundColor: 'rgba(83, 200, 249,0.9)',
						selectedBorder: '1px rgba(83, 200, 249,0.9) solid'
					}
				],

				current: 0,
				mode: 'default',
				dotsStyles: {},
				swiperDotIndex: 0
			}
		},
		onLoad() {},
		methods: {
			change(e) {
			            this.current = e.detail.current;
			},
			visibleChange(isShow){ // 列表框的显示隐藏事件
				console.log('isShow::', isShow);
			},
			change({newVal, oldVal, index, orignItem}){ 
				console.log(newVal, oldVal, index, orignItem);
			},
			gopage(){
				uni.navigateTo({
					url: "../choosemodule/choosemodule"
				});
			}
			}
	}
</script>

<style lang="scss">
	.bg-set{
		    position: fixed;
		    width: 100%;
		    height: 100%;
		    top: 0;
		    left: 0;
		    z-index: -1;
		}
		.user-info-box{
			width: 100%;
			box-sizing: border-box;
			padding: 30upx;
			display: flex;
			flex-direction: row;
			align-items: center;
			margin-bottom: 30upx;
			/* .user-image{
				width: 130upx;
				height: 130upx;
				border-radius: 65upx;
			} */
			/* .user-info{
				flex: 1;
				display: flex;
				flex-direction: column;
				padding-left: 20upx;
				box-sizing: border-box;
				z-index: 10;
				.user-logoin-title{
					font-size:36upx;
					font-weight:500;
					color:rgba(255, 85, 0, 1.0);
				}
			} */
	}

		.logo {
			height: 200rpx;
			width: 200rpx;
			margin-top: 200rpx;
			margin-left: auto;
			margin-right: auto;
			margin-bottom: 50rpx;
		}
	
		.text-area {
			display: flex;
			justify-content: center;
		}
	
		.title {
			font-size: 36rpx;
			color: #8f8f94;
		}
	@import '@/common/uni-nvue.scss';
	.swiper-box {
		height: 1608rpx;
	}

	.swiper-item {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: column;
		justify-content: center;
		align-items: center;
		background-color: $uni-text-color-grey;
		color: #fff;
	}

	.image {
		width: 800rpx;
		height: 100vh;
	}

	/* #ifndef APP-NVUE */
	::v-deep .image img {
		-webkit-user-drag: none;
		-khtml-user-drag: none;
		-moz-user-drag: none;
		-o-user-drag: none;
		user-drag: none;
	}
	/* #endif */

	@media screen and (min-width: 500px) {
				.uni-swiper-dot-box {
					width: 100%;
					height: 800rpx;
					margin: 0 auto;
					margin-top: 80rpx;
					
				}

				.image {
					width: 100%;
				}
	}

	.uni-bg-red {
		background-color: #ff5a5f;
	}

	.uni-bg-green {
		background-color: #09bb07;
	}

	.uni-bg-blue {
		background-color: #007aff;
	}

	.example-body {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		flex-direction: row;
		padding: 20rpx;
	}

	.example-body-item {

		flex-direction: row;
		justify-content: center;
		align-items: center;
		margin: 15rpx;
		padding: 15rpx;
		height: 60rpx;
		/* #ifndef APP-NVUE */
		display: flex;
		padding: 0 15rpx;
		/* #endif */
		flex: 1;
		border-color: #e5e5e5;
		border-style: solid;
		border-width: 1px;
		border-radius: 5px;
	}

	.example-body-item-text {
		font-size: 28rpx;
		color: #333;
	}

	.example-body-dots {
		width: 16rpx;
		height: 16rpx;
		border-radius: 50px;
		background-color: #333333;
		margin-left: 10rpx;
	}

	.active {
		border-style: solid;
		border-color: #007aff;
		border-width: 1px;
	}
</style>
