<template>
	<view>
		<view class="header" :style="{'height':titleBarHeight,'padding-top':statusBarHeight,'background-color': '#F8F8F8'}">
			<image class='header-back' src='/static/logo.png' style="height: 50upx; width: 50upx;" @click="gotoConn()"></image>
			<view class="header-title">学习界面</view>
		</view>
		<view :style="{'height':titleBarHeight,'padding-top':statusBarHeight}"></view>
		
		<view style="width: 10%; margin: auto;margin-bottom: 20px;">
			<xfl-select 
			:list="list"
			:clearable="false"
			:showItemNum="5" 
			:listShow="true"
			:isCanInput="true"  
			:style_Container="listBoxStyle"
			:placeholder = "'placeholder'"
			:initValue="'中'"
			:selectHideType="'independent'"
			>
			</xfl-select>
		</view>
		
		<view>
			<input v-model="value" focus placeholder="在此输入文字" style="width: 80%; margin: auto;margin-bottom: 20px;">
		</view>
		<view class="classification">
			<view class="tag" @click="goTag(0)">
				<image src='../../static/01.gif' style="height: 50upx; width: 50upx;"></image>
				<view style="font-size: small;">消息</view>
			</view>
			<view class="tag" @click="goTag(1)">
				<image src='../../static/02.gif' style="height: 50upx; width: 50upx;"></image>
				<view style="font-size: small;">历史</view>
			</view>
			<view class="tag" @click="goTag(2)">
				<image src='../../static/04.png' style="height: 50upx; width: 50upx;"></image>
				<view style="font-size: small;">广场</view>
			</view>
			<view class="tag" @click="goTag(3)">
				<image src='../../static/05.gif' style="height: 50upx; width: 50upx;"></image>
				<view style="font-size: small;">排行榜</view>
			</view>
		</view>
		<view class='btns'>
			<view>
			<button>
				<image src='../../static/images/study.gif'></image>
			</button>
			</view>
			<view>
			<button>
				<image src='../../static/images/teach.png'></image>
			</button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				listBoxStyle: `height: 40px; font-size: 16px;`,
				list: [
					'中',
					'英',
					'韩',
					'日', 
					'西',
				],
				userInfo: {},
				hasUserInfo: false,
				canIUseGetUserProfile: false,
				code:'',
				openid: '',
				session_key: '',
				encryptedData: ',',
				iv: '',
			}
		},
		created() {
			var that = this;
			uni.getSystemInfo({
				success: function(res) {
					if (res.model.indexOf('iPhone') !== -1) {
						that.titleBarHeight = '44px';
					} else {
						that.titleBarHeight = '48px';
					}
					that.statusBarHeight = res.statusBarHeight + 'px'
				}	
			})
			
		},
		methods: {
			gotoConn(){
				uni.navigateTo({
					url: "../mine/mine"
				});
			}
			
		}
	}
</script>

<style>
	.btns {
		margin-top: 40rpx;
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
	}
	.header {
		display: flex;
		align-items: center;
		top: 0;
		position: fixed;
		width: 100%;
		z-index: 100;
		left:0;
	}
	.header-title {
		position: absolute;
		left: 50%;
		font-size: 38upx;
		transform: translateX(-50%);
	}
	.header-back {
		position: absolute;
		left:15upx;
		font-size:30upx;
		padding: 10upx;
		/* border-radius: 50%; */
	}
	.classification {
		display: flex;
		align-items: stretch;
		align-content: stretch;
		justify-content: space-around;
		flex-wrap: wrap;
	}
	.tag {
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 15%;
		margin-top: 20px;
	}

</style>
