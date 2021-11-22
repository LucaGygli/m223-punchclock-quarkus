<template>
<q-page>
    <div class="LoginPage">
        <h2>Login</h2>
        <div style="max-width: 300px;" class="q-mx-auto">
            <form-wrapper :validator="$v">
                <form-group name="username">
                    <q-input v-model="username" label="Username" slot-scope="{attrs}" v-bind="attrs" /><br />
                </form-group>

                <form-group name="password">
                    <q-input v-model="password" type="password" label="Password" slot-scope="{attrs}" v-bind="attrs" />
                </form-group>
            </form-wrapper>
        </div>
        <q-btn class="LoginButton" color="black" label="Registrieren"  unelevated to="/Register" style="margin-right: 10px;"/>
        <q-btn class="LoginButton" color="black" label="Login" @click="submitLogin"/>
       
    </div>

</q-page>
</template>

<script>
import { required } from 'vuelidate/lib/validators'
import { Notify } from 'quasar'

export default {
    name: 'Loginpage',
    data() {
        return {
            username: "",
            password: "",
        }
    },
    methods: {
        async submitLogin() {
            this.$store.dispatch("auth/logout");
            let res = await axios.post('/auth/Login', {
                username: this.username,
                password: this.password
            })
            if (res.status === 200) {
                const token = res.data
                if (token == undefined) {
                    this.password = ''
                    return;
                }
                this.$store.dispatch("auth/logout");
                this.$store.dispatch("auth/login", {
                    jwt: token
                });
                this.$router.push('/home')
            }
        }
    }
}
</script>

<style>
.LoginPage {
    text-align: center;
    position: fixed;
    top: 24%;
    right: 0%;
    width: 100%;
}
.LoginButton{
    margin-top: 20px;
}
</style>
